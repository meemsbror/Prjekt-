package com.saints.gamecode;

import com.saints.gamecode.interfaces.IGraphics;
import com.saints.gamecode.interfaces.IKeyInput;
import com.saints.gamecode.interfaces.IScene;
import com.saints.gamecode.scenes.Arena;
import com.saints.gamecode.scenes.CharacterSelectController;
import com.saints.gamecode.scenes.MapSelectController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class Game implements PropertyChangeListener{

    //Saves the graphics and input so that it can create new scenes
    final private IGraphics graphics;
    final private IKeyInput input;

    //The currently selected scene that will update
    private IScene currentScene;

    //The arena scene
    private Arena arena;
    private CharacterSelectController csc;
    private MapSelectController msc;

    public Game(IKeyInput input, IGraphics graphics){
        this.graphics = graphics;
        this.input = input;
        this.arena = new Arena(CharacterFactory.createCharacter("Smurf"),CharacterFactory.createCharacter("Smurf"), input, graphics);
        this.currentScene = arena;
    }

    public void update(float delta){
        currentScene.update(delta);
    }

    public void propertyChange(PropertyChangeEvent event){

    }
}
