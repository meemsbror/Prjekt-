package com.saints.gamecode;

import com.saints.gamecode.gameobjects.characters.Character;
import com.saints.gamecode.interfaces.IKeyInput;

public class CharacterController {

    private final Character player1, player2;
    private final IKeyInput input;
    private Direction direction;
    private long p1AttackTimer, p2AttackTimer, time = System.currentTimeMillis();

    public CharacterController(Character player1, Character player2, IKeyInput input){
        this.player1 = player1;
        this.player2 = player2;
        this.input = input;
    }

    public Position getP1Position(){
        return player1.getPosition();
    }

    public Position getP2Position(){
        return player2.getPosition();
    }

    public void update(){
        time = System.currentTimeMillis();

        movePlayers();
    }

    public void movePlayers(){
        for(Direction dir: Direction.values()){
            if(input.isKeyPressed(dir)){
                keyPressed(dir);
            }
        }
    }


    public void keyPressed(Direction direction){
        //TODO: Change the key to a ENUM so we don't have to use KeyEvent.
        switch(direction){
            case P1LEFT:
                player1.move(-5,0);
                break;
            case P1RIGHT :
                player1.move(5,0);
                break;
            case P1JUMP:
                player1.move(0,5);
                break;
            case P1DIVE:
                player1.move(0,-5);
                break;
            case P1ATTACK:
                //One second cooldown on the attack
                System.out.println(p1AttackTimer);
                if(p1AttackTimer + 1000 < time){
                    //checks if player 2 is within player1s attack hitbox
                    System.out.println("Attacks!");
                    if(player1.attack(player2)){
                        player2.takeDamage(player1.getDamage());
                    };
                    p1AttackTimer = time;
                }
                System.out.println("Didnt attack :/");
                break;


        //TODO: player2 movement
            case P2LEFT:
                player2.move(-1,0);
                break;
            case P2RIGHT:
                player2.move(1,0);
                break;
            case P2JUMP:
                player2.move(0,1);
                break;
            case P2DIVE:
                player2.move(0,-1);
            case P2ATTACK:
                if(player2.attack(player1)) {
                    //player1.takeDamage();
                }
            break;
       }
    }

    public void keyReleased(int key){
        //TODO
    }
}
