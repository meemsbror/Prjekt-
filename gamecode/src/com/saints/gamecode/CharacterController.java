package com.saints.gamecode;

import java.awt.event.KeyEvent;

public class CharacterController {

    private final Character player1;
    private final Character player2;

    public CharacterController(Character player1, Character player2){
        this.player1 = player1;
        this.player2 = player2;
    }


    public void keyPressed(int key){
        //TODO: Change the key to a ENUM so we don't have to use KeyEvent.
        switch(key){
            case KeyEvent.VK_LEFT :
                player1.move(-1,0);
                break;
            case KeyEvent.VK_RIGHT :
                player1.move(1,0);
                break;
            case KeyEvent.VK_UP :
                player1.move(0,1);
                break;
            case KeyEvent.VK_DOWN :
                player1.move(0,-1);

                //TODO: player2 movement
       }
    }

    public void keyReleased(int key){
        //TODO
    }
}
