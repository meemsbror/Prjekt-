package com.saints.gamecode;

import com.saints.gamecode.gameobjects.GameObject;
import com.saints.gamecode.gameobjects.characters.Character;

import com.saints.gamecode.gameobjects.items.Item;
import com.saints.gamecode.gameobjects.items.Platform;
import com.saints.gamecode.interfaces.IEntity;
import com.saints.gamecode.interfaces.IGraphics;
import com.saints.gamecode.interfaces.IKeyInput;
import com.saints.gamecode.interfaces.IPhysics;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

//Controller class that controls both players
public class CharacterController {

    private final HealthBar HPBar = HealthBar.getInstance();
    private Character player1, player2;
    private final Platform platform;

    //All items in a list
    private final ArrayList<IEntity> gameObjects;

    private final IKeyInput input;
    private float time;
    private IPhysics physics = Physics.getInstance();


    private Map<Direction, Direction> P1_DIRECTIONS, P2_DIRECTIONS;
    private IGraphics graphics;

    public CharacterController(List<IEntity> gameObjects, IKeyInput input, Platform platform, IGraphics graphics){
        this.gameObjects = (ArrayList)gameObjects;
        this.input = input;
        this.platform = platform;

        initiatePlayerDirections();
        this.graphics = graphics;
    }

    //Sets the starting position of both players
    public void setStartPositions(){
        //TODO: start pos should vary with map
        player1.setPosition(0,0);
        player2.setPosition(300,0);
    }

    public Position getP1Position(){
        return player1.getPosition();
    }

    public Position getP2Position(){
        return player2.getPosition();
    }

    public Position getPlayerPosition(GameObject gameObject){
        return gameObject.getPosition();
    }

    //Updates the model
    public void update(float delta){
            time += delta;
            updateCharacterDirection(delta);
            moveCharacters(delta);
            checkCollision(delta);
            checkPowerUp(delta);
    }

    private void checkPowerUp(float delta) {
        if(player1.getAttackPowerUpTime() < time){
            player1.powerUp(false);
        }
    }

    //Checks if the keys for player movement are pressed and updates their direction
    private void updateCharacterDirection(float delta){

        player1.setMoving(false);
        player2.setMoving(false);
        //Iterates all directions and checks if the corresponding key is pressed

        iteratePlayerDirections(P1_DIRECTIONS, player1, player2);
        iteratePlayerDirections(P2_DIRECTIONS, player2, player1);

        updateState(player1);
        updateState(player2);

        //If the player is in the air add gravity so that it falls
        applyGravity(player1,delta);
        applyGravity(player2,delta);

        //If the player is falling below platform, reset y-velocity and put it on platform
        applyPlatform(player1, player2);
        applyPlatform(player2, player1);

	    // If the player falls below posY(-150) kill that player.
	    applyFallDeath(player1);
	    applyFallDeath(player2);


    }

    private void iteratePlayerDirections(Map<Direction, Direction> map, Character character, Character opositeCharacter){
        for(Direction dir: map.keySet()){
            if(input.isKeyPressed(dir)){
                keyPressed(map.get(dir), character, opositeCharacter);
            }
        }
    }

    //Checks if the Characters have collided and reverts the player position to the last frame
    private void checkCollision(float delta){
        Position pos1 = player1.getPos();
        Position pos2 = player2.getPos();
        Position oldPos1 = player1.getOldPos();
        Position oldPos2 = player2.getOldPos();

        //Checks if a collision has happend and moves the players accordingly
        if(physics.hasCollided(player1,player2)){
            if(oldPos1.getY()>oldPos2.getY()+player2.getHeight()){
                player1.setPosition(pos1.getX(),pos2.getY()+player2.getHeight()+1);
                player1.setAirborne(false);
            }
            else if(oldPos2.getY()>oldPos1.getY()+player1.getHeight()){
                player2.setPosition(pos2.getX(),pos1.getY()+player1.getHeight()+1);
                player2.setAirborne(false);
            }
            else{
                player1.revertHorizontalPosition();
                player2.revertHorizontalPosition();
            }
        }
    }


    private void applyFallDeath(Character player){
        if(player.getPos().getY() < -150) {
	        if (player.equals(player1)){
		        HPBar.killP1();
	        }if (player.equals(player2)){
		        HPBar.killP2();
	        }
	        // do nothing otherwise
	        return;
        }
    }

    private void applyPlatform(GameObject gameObject, GameObject gameObject2){

        if(physics.isBelowPlatform(gameObject, platform)){
            gameObject.resetVerticalSpeed();// set y-vector to 0
            gameObject.setPosition(getPlayerPosition(gameObject).getX(),platform.getY());// set y-pos to platforms y-pos
            gameObject.setAirborne(false);
        }
        //if walking outside platform isAirborne is set to true
        gameObject.setAirborne(physics.isInAir(gameObject, platform, gameObject2));
    }

    //Adds a gravity vector the the object if it is in the air
    private void applyGravity(GameObject gameObject, float delta){

        if(gameObject.isAirborne()){
            Vector2D deltaGravity = physics.getGravity(delta);
            gameObject.changeDirection(deltaGravity);
        }
    }

    //Moves the Characters in their direction.
    public void moveCharacters(float delta){
        player1.move(player1.getHorizontalSpeed()*delta,player1.getVerticalSpeed()*delta);
        player2.move(player2.getHorizontalSpeed()*delta,player2.getVerticalSpeed()*delta);
    }



    //Checks what state a character should be in and updates it correspond to it
    public void updateState(Character player){
        if(!player.isMoving()) {
            player.resetHorizontalSpeed();
            player.setState(State.STALL);
        }else{
            player.setState(State.WALK);
        }
        if(player.isAirborne()) {
            player.setState(State.JUMP);
        }
        if(player.getAttackCD() > time){
            player.setState(State.PUNCH);
        }
    }


    //Takes a direction and a player and updates the model depending on the input (direction)
    public void keyPressed(Direction direction, Character character, Character opositeCharacter){
        switch(direction){

            //Player movement
            case LEFT:
                moveLeft(character);
                break;
            case RIGHT :
                moveRight(character);
                break;
            case JUMP:
                jump(character);
                break;
            case DIVE:
                //Maybe implement crouch
                break;
            case ATTACK:
                attack(character, opositeCharacter);
                break;
        }
    }
    public void attack(Character character, Character opositeCharacter){
        if(!(character.getState() == State.PUNCH)){
            if(character.attack(opositeCharacter)){
                HPBar.dealDamage(character.getDamage());

                if (HPBar.getIsGameOver()){
                    System.out.println(HPBar.getWinner()); //TODO: end game, how?
                }
            }
            for(int i = gameObjects.size()-1; i >= 0; i--){
                if(gameObjects.get(i) instanceof Item) {
                    Item item = (Item) gameObjects.get(i);
                    if(character.attack(item)){
                        character.setAttackPowerUpTime(time + item.getDuration());
                        character.powerUp(true);
                        gameObjects.remove(i);
                    }
                }
            }
            //Sets the cooldown for next attack, dependant on current time and what sort of character that is attacking.
            character.setAttackCD(time);
        }
    }


    //Puts the different playerDirections and maps them to the general direction
    public void initiatePlayerDirections() {
        P1_DIRECTIONS = new HashMap<Direction, Direction>();
        P2_DIRECTIONS = new HashMap<Direction, Direction>();

        P1_DIRECTIONS.put(Direction.P1RIGHT, Direction.RIGHT);
        P1_DIRECTIONS.put(Direction.P1LEFT, Direction.LEFT);
        P1_DIRECTIONS.put(Direction.P1JUMP, Direction.JUMP);
        P1_DIRECTIONS.put(Direction.P1DIVE, Direction.JUMP);
        P1_DIRECTIONS.put(Direction.P1ATTACK, Direction.ATTACK);
        P1_DIRECTIONS.put(Direction.P1STOP, Direction.STOP);

        P2_DIRECTIONS.put(Direction.P2RIGHT, Direction.RIGHT);
        P2_DIRECTIONS.put(Direction.P2LEFT, Direction.LEFT);
        P2_DIRECTIONS.put(Direction.P2JUMP, Direction.JUMP);
        P2_DIRECTIONS.put(Direction.P2DIVE, Direction.JUMP);
        P2_DIRECTIONS.put(Direction.P2ATTACK, Direction.ATTACK);
        P2_DIRECTIONS.put(Direction.P2STOP, Direction.STOP);
    }


    //Asks the character to jump
    public void jump(Character character){
        if(!character.isAirborne() || !character.isDoubleJumped()){
            if(character.getJumpTimer() < time) {
                character.jump();
                character.setJumpTimer(time + 0.4f);
            }
        }
    }

    //Asks a character to move right
    private void moveRight(Character character){
        character.moveRight();
    }

    //Asks a character to move left
    private void moveLeft(Character character){
        character.moveLeft();
    }

    //Not sure if necessary
    public void keyReleased(int key){
        //TODO
    }

    public void setCharacters(Character player1, Character player2){
        this.player1 = player1;
        this.player2 = player2;
        setStartPositions();
        initiateHealthBar();
        setStartPositions();
    }

    private void initiateHealthBar(){
        int HPBarHelper = (player1.getHitPoints() + player2.getHitPoints());
        this.HPBar.setStartingMax(HPBarHelper);
        this.HPBar.setP2Limit(HPBarHelper);
        // sets divider correctly for case when Characters have different health-pools
        this.HPBar.setDivider(HPBarHelper - player2.getHitPoints());
        this.HPBar.setPosition((graphics.getScreenWidth()/2)-(HPBar.getWidth()/2),
                (graphics.getScreenHeight()-80)); // HPBar appears on top of screen
        this.gameObjects.add(HPBar);
    }
}
