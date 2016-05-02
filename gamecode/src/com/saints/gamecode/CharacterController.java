package com.saints.gamecode;

import com.saints.gamecode.gameobjects.characters.Character;
import com.saints.gamecode.interfaces.IKeyInput;

public class CharacterController {

    private final HealthBar HPBar = HealthBar.getInstance();
    private final Character player1, player2;
    private final IKeyInput input;
    private Direction direction;
    private long p1AttackTimer, p2AttackTimer, time = System.currentTimeMillis();
    private Physics physics = Physics.getInstance();





    public CharacterController(Character player1, Character player2, IKeyInput input){
        this.player1 = player1;
        this.player2 = player2;
        this.input = input;

        int HPBarHelper = player1.getHitPoints() + player2.getHitPoints();
        this.HPBar.setMaxHealth(HPBarHelper);
        this.HPBar.setDivider(HPBarHelper - player1.getHitPoints());
    }

    public Position getP1Position(){
        return player1.getPosition();
    }

    public Position getP2Position(){
        return player2.getPosition();
    }

    public void update(long delta){
        time = System.currentTimeMillis();
        movePlayers(delta);

    }

    public void movePlayers(long delta){
        for(Direction dir: Direction.values()){
            if(input.isKeyPressed(dir)){
                keyPressed(dir);
            }
        }

        Vector2D deltaGravity = physics.getGravity(delta);
        /*
        if(player1.isAirborne()){
            player1.changeDirection(deltaGravity);
        }
        */

        player1.move(player1.getHorizontalSpeed()*delta,player1.getVerticalSpeed()*delta);
    }

    public void jump(Character character){
        if(!character.isAirborne()){
            character.jump();
        }
    }


    public void keyPressed(Direction direction){
        switch(direction){
            case P1LEFT:
                player1.setState(State.WALK);
                player1.move(-5,0);
                break;
            case P1RIGHT :
                player1.setState(State.WALK);
                player1.move(5,0);
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


        //TODO: player2 movement
            case P2LEFT:
                player2.move(-1,0);
                break;
            case P2RIGHT:
                player2.move(1,0);
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

    public void keyReleased(int key){
        //TODO
    }
}
