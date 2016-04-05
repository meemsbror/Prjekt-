package com.saints.gamecode;

import com.badlogic.gdx.Game;
import com.saints.gamecode.characters.Character;
import com.saints.gamecode.characters.SmurfCharacter;
import com.saints.gamecode.dependencies.LibGDXGraphics;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;


public class Arena {

    private final CharacterController characterController;
    private final KeyListener keyListener;
    private final LibGDXGraphics libGDXGraphics;

    private final boolean running = true;

    List<GameObject> gameObjects = new ArrayList<GameObject>();

    public Arena (Character player1, Character player2){
        this.characterController = new CharacterController(player1,player2);
        this.keyListener = DependenciesHelper.getKeyListener(this);
        libGDXGraphics = new LibGDXGraphics();
        startMatch();
    }

    //Starts a match between two players
    public void startMatch(){
        gameObjects.add(new SmurfCharacter(0,0,10,10));
        gameObjects.add(new SmurfCharacter(100,100,10,10));
        while(running){
            libGDXGraphics.render(gameObjects);
        }
    }

    //Gets notified if a key has been pressed and performs appropriate action
    public void keyPressed(Direction direction){

        characterController.keyPressed(direction);

    }

    //Gets notified if a key has been released and performs appropriate action
    public void keyReleased(int key){

        characterController.keyReleased(key);
    }
}
