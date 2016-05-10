package com.saints.gamecode.scenes;

import com.saints.gamecode.CharacterController;
import com.saints.gamecode.Direction;
import com.saints.gamecode.gameobjects.GameObject;
import com.saints.gamecode.gameobjects.characters.Character;
import com.saints.gamecode.interfaces.IGraphics;
//import com.saints.gamecode.gameobjects.items.Platform;
import com.saints.gamecode.interfaces.IKeyInput;
import com.saints.gamecode.interfaces.IScene;

import java.util.ArrayList;
import java.util.List;


public class Arena implements IScene{

    private final CharacterController characterController;
    private final IKeyInput input;
    private final IGraphics graphics;

    private final boolean running = true;

    List<GameObject> gameObjects = new ArrayList<GameObject>();

    public Arena (Character player1, Character player2, IKeyInput input, IGraphics graphics){
        gameObjects.add(player1);
        gameObjects.add(player2);
        //Platform.setPlatform(50,50,1000,50);
        this.input = input;
        this.graphics = graphics;
        this.characterController = new CharacterController(player1, player2,input);
        addCharacterAnimation(player1);
        addCharacterAnimation(player2);
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

    private void addCharacterAnimation(Character player){

        graphics.addAnimation(player.getSpriteSheetPath());
    }

    //Gets called from the game loop when the arena should update
    public void update(float delta){
        characterController.update(delta);
        graphics.update(delta,getGameObjects());
    }
}
