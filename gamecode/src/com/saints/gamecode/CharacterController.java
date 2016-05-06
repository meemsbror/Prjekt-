package com.saints.gamecode;

import com.saints.gamecode.gameobjects.GameObject;
import com.saints.gamecode.gameobjects.characters.Character;
import com.saints.gamecode.interfaces.IKeyInput;
import com.saints.gamecode.interfaces.IPhysics;

//Controller class that controls both players
public class CharacterController {

    private final HealthBar HPBar = HealthBar.getInstance();
    private final Character player1, player2;
    private final IKeyInput input;
    private Direction direction;
    private long p1AttackTimer, p2AttackTimer, time = System.currentTimeMillis();
    private IPhysics physics = Physics.getInstance();





    public CharacterController(Character player1, Character player2, IKeyInput input){
        this.player1 = player1;
        this.player2 = player2;
        this.input = input;

        int HPBarHelper = player1.getHitPoints() + player2.getHitPoints();
        this.HPBar.setMaxHealth(HPBarHelper);
        this.HPBar.setDivider(HPBarHelper - player1.getHitPoints());
        setStartPositions();
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
        time = System.currentTimeMillis();
        updateCharacterDirection(delta);
        moveCharacters(delta);
    }

    //Checks if the keys for player movement are pressed and updates their direction
    private void updateCharacterDirection(float delta){

        //Iterates all directions and checks if the corresponding key is pressed
        for(Direction dir: Direction.values()){
            if(input.isKeyPressed(dir)) {
                keyPressed(dir);
            }
        }


        //If the player is in the air add gravity so that it falls

        applyGravity(player1,delta);
        applyGravity(player2,delta);

        if(physics.hasCollided(player1,player2)){
            player1.resetHorizontalSpeed();
            player2.resetHorizontalSpeed();
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
    public void keyPressed(Direction direction){
        switch(direction){

            //Player 1 movement
            case P1LEFT:
                player1.setState(State.WALK);
                moveLeft(player1);
                break;
            case P1RIGHT :
                player1.setState(State.WALK);
                moveRight(player1);
                break;
            case P1JUMP:
                player1.setState(State.JUMP);
                jump(player1);
                break;
            case P1DIVE:
                player1.move(0,-5);
                break;
            case P1ATTACK:
                //One second cooldown on the attack
                if(p1AttackTimer + 1000 < time){
                player1.setState(State.PUNCH);
                     //   HPBar.updateDivider(player1.getDamage());
                    p1AttackTimer = time;
                }
                break;
            default:
                player1.setState(State.STALL);
               break;


            //Player 2 movement
            case P2LEFT:
                moveLeft(player2);
                break;
            case P2RIGHT:
                moveRight(player2);
                break;
            case P2JUMP:
                jump(player2);
                break;
            case P2DIVE:
                player2.move(0f,-1f);
            case P2ATTACK:
                //One second cooldown on the attack
                System.out.println(p2AttackTimer);
                if(p2AttackTimer + 1000 < time){
                    //checks if player 2 is within player1s attack hitbox
                    System.out.println("Attacks!");
                   if(player2.attack(player1)){
                        // negative damage to represent the divider movement
                        HPBar.updateDivider(-player2.getDamage());
                    }
                    p2AttackTimer = time;
                }
                System.out.println("Didnt attack :/");
            break;
       }
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
