package com.saints.gamecode.scenes;

import com.saints.gamecode.AnimationObject;
import com.saints.gamecode.CharacterController;
import com.saints.gamecode.Direction;
import com.saints.gamecode.gameobjects.GameObject;
import com.saints.gamecode.gameobjects.characters.Character;
import com.saints.gamecode.gameobjects.items.AttackPower;
import com.saints.gamecode.gameobjects.items.Platform;
import com.saints.gamecode.interfaces.IGraphics;
import com.saints.gamecode.interfaces.IKeyInput;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;


public class Arena extends Scene{

    private final CharacterController characterController;
    private final IKeyInput input;
    private final IGraphics graphics;
    private PropertyChangeSupport pcs;

    private final boolean running = true;

    List<GameObject> gameObjects = new ArrayList<GameObject>();

    public Arena (IKeyInput input, IGraphics graphics){
        pcs = new PropertyChangeSupport(this);
        this.input = input;
        this.graphics = graphics;
        startMatch();

        //TODO - Fix Platform with PlatformFactory
        Platform platform= new Platform(50,50,500,30); // This is shit right now (Y)
        this.characterController = new CharacterController(gameObjects, input, platform);

    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    //Starts a match between two players
    public void startMatch(){
        //Adds all item animations
        graphics.addAnimation(new AnimationObject("assets/pictures/ItemsSprites.png", 4, 2, 1f/12f));
    }

    private void addCharacterAnimation(Character player){
        graphics.addAnimation(player.getAnimationObject());
        graphics.addAnimation(player.getStraightAttack().getAnimationObject());
    }

    //Gets called from the game loop when the arena should update
    public void update(float delta) {
        //TODO Check input for pause :)
            characterController.update(delta);
       // if (!characterController.isPaused()) {
        System.out.println("kommer den in hit? arena update()");
            graphics.update(delta, getGameObjects());
        //}
    }

    public void setCharacters(Character player1, Character player2){
        gameObjects.add(player1);
        gameObjects.add(player2);
        addCharacterAnimation(player1);
        addCharacterAnimation(player2);
        characterController.setCharacters(player1, player2);
        addItem();
    }
    public void addItem(){
        gameObjects.add(new AttackPower(100,100,50,50,new AnimationObject("assets/pictures/ItemsSprites.png", 4, 2, 1f/12f)));
    }
}
