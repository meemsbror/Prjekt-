package com.saints.gamecode;

import com.saints.gamecode.dependencies.DependenciesHelper;
import com.saints.gamecode.dependencies.KeyInput;
import java.awt.event.KeyListener;


public class Arena {

    private final CharacterController characterController;
    private final KeyListener keyListener;

    public Arena (Character player1, Character player2){
        this.characterController = new CharacterController(player1,player2);
        this.keyListener = DependenciesHelper.getKeyListener(this);
    }

    //Starts a match between two players
    public void startMatch(){

    }

    //Gets notified if a key has been pressed and performs appropriate action
    public void keyPressed(int key){

        characterController.keyPressed(key);

    }

    //Gets notified if a key has been released and performs appropriate action
    public void keyReleased(int key){

        characterController.keyReleased(key);
    }

}
