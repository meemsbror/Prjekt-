package com.saints.gamecode;

import com.saints.gamecode.interfaces.IGraphics;
import com.saints.gamecode.interfaces.IKeyInput;
import com.saints.gamecode.interfaces.IScene;
import com.saints.gamecode.scenes.Arena;

public class Game {

    //Saves the graphics and input so that it can create new scenes
    final private IGraphics graphics;
    final private IKeyInput input;

    //The currently selected scene that will update
    private IScene currentScene;

    //The arena scene
    private Arena arena;

    public Game(IKeyInput input, IGraphics graphics){
        this.graphics = graphics;
        this.input = input;
        this.arena = new Arena(CharacterFactory.createCharacter("Smurf"),CharacterFactory.createCharacter("Smurf"), input, graphics);
        this.currentScene = arena;
    }

    public void update(float delta){
        currentScene.update(delta);
    }
}
