package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.saints.gamecode.Direction;
import com.saints.gamecode.interfaces.IKeyInput;
import com.sun.javafx.collections.MappingChange;

public class LibGDXInput implements IKeyInput {

    public MappingChange.Map<Direction,Input.Keys> map;
    private final Input input;

    public LibGDXInput (Input input){

        this.input = input;
    }


    public boolean isKeyPressed(Direction direction){


        return input.isKeyPressed(translateKey(direction));
    }


    private int translateKey(Direction direction){
        return 5;
    }


    private void initiate(){

    }
}
