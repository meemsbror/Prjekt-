package com.saints.gamecode.scenes;

import com.saints.gamecode.AnimationObject;
import com.saints.gamecode.CharacterController;
import com.saints.gamecode.Direction;
import com.saints.gamecode.HealthBar;
import com.saints.gamecode.PauseMenu;
import com.saints.gamecode.Position;
import com.saints.gamecode.gameobjects.GameObject;
import com.saints.gamecode.gameobjects.characters.Character;
import com.saints.gamecode.gameobjects.items.AttackPower;
import com.saints.gamecode.gameobjects.items.Platform;
import com.saints.gamecode.interfaces.IEntity;
import com.saints.gamecode.interfaces.IGraphics;
import com.saints.gamecode.interfaces.IKeyInput;

import java.beans.PropertyChangeSupport;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Arena extends Scene{

    private final CharacterController characterController;
    private final IKeyInput input;
    private final IGraphics graphics;
    private PropertyChangeSupport pcs;

    private float pauseTimer = 0;
    private int currentPauseOption = 0;

    private final boolean running = true;


    List<IEntity> gameObjects = new ArrayList<IEntity>();

    PauseMenu pauseMenu = new PauseMenu(new AnimationObject("assets/pictures/PauseMenu.png", 1, 3, 1));

    public Arena (IKeyInput input, IGraphics graphics){
        pcs = new PropertyChangeSupport(this);
        this.input = input;
        this.graphics = graphics;
        startMatch();

        //TODO - Fix Platform with PlatformFactory
        Platform platform= new Platform(50,50,500,30); // This is shit right now (Y)
        this.characterController = new CharacterController(gameObjects, input, platform, graphics);

    }

    public List<IEntity> getGameObjects() {
        return gameObjects;
    }

    //Starts a match between two players
    public void startMatch(){
        addMap();
        addAnimations();
        addItem();
        addHealthBarAnimation();
    }
    public void addHealthBarAnimation(){
        graphics.addAnimation(HealthBar.getInstance().getAnimationObject1());
        graphics.addAnimation(HealthBar.getInstance().getAnimationObject2());
    }

    private void addMap() {

    }

    private void addCharacterAnimation(Character player){
        graphics.addAnimation(player.getAnimationObject());
        graphics.addAnimation(player.getStraightAttack().getAnimationObject());
    }
    private void addAnimations(){
        //Adds all item animations
        graphics.addAnimation(new AnimationObject("assets/pictures/ItemsSprites.png", 4, 2, 1f/12f));
        //Add menu animation
        graphics.addAnimation(pauseMenu.getAnimationObject());
    }

    //Gets called from the game loop when the arena should update
    public void update(float delta) {
        if (!pauseMenu.isPaused()) {
            pauseMenu.setPaused(input.isKeyPressed(Direction.SELECT), delta);
            if(gameObjects.contains(pauseMenu)){
               gameObjects.remove(pauseMenu);
            }
            graphics.update(delta, getGameObjects());
            characterController.update(delta);
        }else{
            pauseMenu.updatePaused(delta, input);
            if(!(gameObjects.contains(pauseMenu))){
                gameObjects.add(pauseMenu);
            }
            delta = 0;
            graphics.update(delta, getGameObjects());
        }
    }

    public int getCurrentPauseOption() {
        return currentPauseOption;
    }

    public void setCharacters(Character player1, Character player2){
        gameObjects.add(player1);
        gameObjects.add(player2);
        addCharacterAnimation(player1);
        addCharacterAnimation(player2);
        characterController.setCharacters(player1, player2);
    }
    public void addItem(){
        gameObjects.add(new AttackPower(100,100,50,50,new AnimationObject("assets/pictures/ItemsSprites.png", 4, 2, 1f/12f)));
    }
}
