package com.saints.gamecode.scenes;

import com.saints.gamecode.*;
import com.saints.gamecode.gameobjects.characters.Character;
import com.saints.gamecode.gameobjects.items.AttackPower;
import com.saints.gamecode.gameobjects.items.Platform;
import com.saints.gamecode.gameobjects.items.SwapHealth;
import com.saints.gamecode.interfaces.IEntity;
import com.saints.gamecode.interfaces.IGraphics;
import com.saints.gamecode.interfaces.IKeyInput;
import com.saints.gamecode.maps.Map;
import com.saints.gamecode.maps.SandboxMap;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;


public class Arena extends Scene implements PropertyChangeListener{

    private final CharacterController characterController;
    private final IKeyInput input;
    private final IGraphics graphics;
    private PropertyChangeSupport pcs;
    private float pauseTimer = 0;
    private int currentPauseOption = 0;

    private final boolean running = true;

    private Map map = new SandboxMap();


    List<IEntity> gameObjects = new ArrayList<IEntity>();

    PauseMenu pauseMenu = new PauseMenu(new AnimationObject("assets/pictures/PauseMenu.png", 1, 3, 1));


    public Arena (IKeyInput input, IGraphics graphics){
        pcs = new PropertyChangeSupport(this);
        this.input = input;
        this.graphics = graphics;

        startMatch();

        this.characterController = new CharacterController(gameObjects, input, map.getPlatformList(), graphics);
	    this.characterController.addPropertyChangeListener(this);

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
        graphics.addTexture("assets/pictures/saints.of.chalmers-sandbox.png");
        graphics.addTexture("assets/pictures/UmpMap.jpg");
        graphics.addTexture("assets/pictures/SandboxMap2.png");
        //graphics.addAnimation(new AnimationObject("assets/pictures/saints.of.chalmers-sandbox.png", 1,1,1));
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
            graphics.update(delta, getGameObjects(), map.getBackground());
            characterController.update(delta);
        }else{
            if(pauseMenu.updatePaused(delta, input)) {
                gameObjects.clear();
                pauseMenu.forcePaused(false);
                firePropertyChange("", null, null);
            }
            if(!(gameObjects.contains(pauseMenu))){
                gameObjects.add(pauseMenu);
            }
            delta = 0;
            graphics.update(delta, getGameObjects(), map.getBackground());
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
        gameObjects.add(new SwapHealth(400,300,50,50,new AnimationObject("assets/pictures/ItemsSprites.png", 4, 2, 1f/12f)));
    }

    public PauseMenu getPauseMenu() {
        return pauseMenu;
    }

    private void endGame(String winner){
        firePropertyChange(winner,null,null);

    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        endGame(evt.getPropertyName());
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
