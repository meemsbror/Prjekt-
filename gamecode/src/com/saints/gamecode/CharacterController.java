package com.saints.gamecode;

import com.saints.gamecode.gameobjects.GameObject;
import com.saints.gamecode.gameobjects.characters.Character;
import com.saints.gamecode.interfaces.IKeyInput;
import com.saints.gamecode.interfaces.IPhysics;

import java.util.HashMap;
import java.util.Map;

//Controller class that controls both players
public class CharacterController {

    private final HealthBar HPBar = HealthBar.getInstance();
    private final Character player1, player2;
    private final IKeyInput input;
    private Direction direction;
    private long p1AttackTimer, p2AttackTimer, time = System.currentTimeMillis();
    private IPhysics physics = Physics.getInstance();

    private Map<Direction, Direction> P1_DIRECTIONS, P2_DIRECTIONS;

    public CharacterController(Character player1, Character player2, IKeyInput input){
        this.player1 = player1;
        this.player2 = player2;
        this.input = input;

        int HPBarHelper = player1.getHitPoints() + player2.getHitPoints();
        this.HPBar.setMaxHealth(HPBarHelper);
        this.HPBar.setDivider(HPBarHelper - player1.getHitPoints());
        setStartPositions();
        initiatePlayerDirections();
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

    public void update(float delta){
        updateCharacterDirection(delta);
        moveCharacters(delta);
        checkCollision(delta);
    }

    //Checks if the keys for player movement are pressed and updates their direction
    private void updateCharacterDirection(float delta){

        player1.setMoving(false);
        player2.setMoving(false);
        //Iterates all directions and checks if the corresponding key is pressed

        iteratePlayerDirections(P1_DIRECTIONS, player1);
        iteratePlayerDirections(P2_DIRECTIONS, player2);

        if(!player1.isMoving()){
            player1.resetHorizontalSpeed();
            if(player1.isAirborne()){
                player1.setState(State.JUMP);
            }else{
                player1.setState(State.STALL);
            }
        }else{
            if(player1.isAirborne()){
                player1.setState(State.JUMP);
            }else{
                player1.setState(State.WALK);
            }
        }

        if(!player2.isMoving()){
            player2.resetHorizontalSpeed();
            if (player2.isAirborne()) {
                player2.setState(State.JUMP);
            } else {
                player2.setState(State.STALL);
            }
        } else {
            if (player2.isAirborne()) {
                player2.setState(State.JUMP);
            } else {
                player2.setState(State.WALK);
            }
        }

        //If the player is in the air add gravity so that it falls
        applyGravity(player1,delta);
        applyGravity(player2,delta);
    }

    private void iteratePlayerDirections(Map<Direction, Direction> map, Character character){
        for(Direction dir: map.keySet()){
            if(input.isKeyPressed(dir)){
                keyPressed(map.get(dir), character);
            }
        }
    }

    public void checkCollision(float delta){
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


    //Asks the character to jump
    public void jump(Character character){
        if(!character.isAirborne()){
            character.jump();
        }
    }


    //
    public void keyPressed(Direction direction, Character character){
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
                character.move(0,-5);
                break;
            case ATTACK:
                //One second cooldown on the attack
                if(p1AttackTimer + 1000 < time){
                player1.setState(State.PUNCH);
                     //   HPBar.updateDivider(player1.getDamage());
                    p1AttackTimer = time;
                }
                break;
       }
    }

    public void initiatePlayerDirections(){
        P1_DIRECTIONS = new HashMap<Direction, Direction>();
        P2_DIRECTIONS = new HashMap<Direction, Direction>();

        P1_DIRECTIONS.put(Direction.P1RIGHT, Direction.RIGHT);
        P1_DIRECTIONS.put(Direction.P1LEFT, Direction.LEFT);
        P1_DIRECTIONS.put(Direction.P1JUMP, Direction.JUMP);
        P1_DIRECTIONS.put(Direction.P1DIVE, Direction.JUMP);
        P1_DIRECTIONS.put(Direction.P1ATTACK, Direction.ATTACK);
        P1_DIRECTIONS.put(Direction.P1STOP, Direction.STOP);

        P2_DIRECTIONS.put(Direction.P2RIGHT,Direction.RIGHT);
        P2_DIRECTIONS.put(Direction.P2LEFT, Direction.LEFT);
        P2_DIRECTIONS.put(Direction.P2JUMP, Direction.JUMP);
        P2_DIRECTIONS.put(Direction.P2DIVE, Direction.JUMP);
        P2_DIRECTIONS.put(Direction.P2ATTACK, Direction.ATTACK);
        P2_DIRECTIONS.put(Direction.P2STOP, Direction.STOP);
    }

    private void moveRight(Character character){
        character.moveRight();
    }

    private void moveLeft(Character character){
        character.moveLeft();
    }

    //Not sure if necessary
    public void keyReleased(int key){
        //TODO
    }
}
