package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.saints.gamecode.Direction;

public class LibGDXInput {

    public final Input input;

    public LibGDXInput (Input input){

        this.input = input;
    }


    public boolean isKeyPressed(Direction direction){


        return input.isKeyPressed(translateKey(direction));
    }


    private int translateKey(Direction direction){
        return 5;
    }


}
