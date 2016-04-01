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
    public void keyPressed(int key){

        characterController.keyPressed(key);

    }


    public void keyReleased(int key){

        characterController.keyReleased(key);
    }

}
