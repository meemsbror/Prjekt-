package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.saints.gamecode.Direction;
import com.saints.gamecode.interfaces.IKeyInput;

import java.util.HashMap;
import java.util.Map;

public class LibGDXInput implements IKeyInput {

    public Map<Direction,Integer> map;
    private final Input input;

    public LibGDXInput (Input input){

        this.input = input;
        initiateDirection();
    }


    public boolean isKeyPressed(Direction direction){
        return input.isKeyPressed(translateKey(direction));
    }


    private int translateKey(Direction direction){
        return map.get(direction);
    }


    private void initiateDirection(){
        map = new HashMap<Direction,Integer>();

        map.put(Direction.P1LEFT,Input.Keys.LEFT);
        map.put(Direction.P1RIGHT,Input.Keys.RIGHT);
        map.put(Direction.P1DIVE,Input.Keys.DOWN);
        map.put(Direction.P1JUMP,Input.Keys.UP);
    }
}
