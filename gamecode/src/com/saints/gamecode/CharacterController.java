package com.saints.gamecode;

import com.saints.gamecode.gameobjects.characters.Character;


public class CharacterController {

    private final Character player1;
    private final Character player2;
    private Direction direction;

    public CharacterController(Character player1, Character player2){
        this.player1 = player1;
        this.player2 = player2;
    }


    public void keyPressed(Direction direction){
        //TODO: Change the key to a ENUM so we don't have to use KeyEvent.
        switch(direction){
            case P1LEFT:
                player1.move(-1,0);
                break;
            case P1RIGHT :
                player1.move(1,0);
                break;
            case P1JUMP:
                player1.move(0,1);
                break;
            case P1DIVE:
                player1.move(0,-1);
                break;
            case P1ATTACK:
                if(player1.attack(player2)){
                    //player2.takeDamage();
                };
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

       }
    }

    public void keyReleased(int key){
        //TODO
    }
}
