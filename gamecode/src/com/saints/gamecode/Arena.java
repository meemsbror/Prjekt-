package com.saints.gamecode;

import com.saints.gamecode.gameobjects.GameObject;
import com.saints.gamecode.gameobjects.characters.Character;
import com.saints.gamecode.interfaces.IKeyInput;
import java.util.ArrayList;
import java.util.List;


public class Arena {

    private final CharacterController characterController;
    private final IKeyInput input;

    private final boolean running = true;

    List<GameObject> gameObjects = new ArrayList<GameObject>();

    public Arena (Character player1, Character player2, IKeyInput input){
        gameObjects.add(player1);
        gameObjects.add(player2);
        this.input = input;
        this.characterController = new CharacterController(player1, player2,input);
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    //Starts a match between two players
    public void startMatch(){

    }

    //Gets notified if a key has been pressed and performs appropriate action
    public void keyPressed(Direction direction){

        characterController.keyPressed(direction);

    }

    //Gets notified if a key has been released and performs appropriate action
    public void keyReleased(int key){

        characterController.keyReleased(key);

    }
    //Gets called from the game loop when the arena should update
    public void update(float delta){
        characterController.update(delta);
    }
}
