package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.saints.gamecode.utils.Direction;
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

    //checks if the key the direction refers to i pressed
    @Override
    public boolean isKeyPressed(Direction direction){
        return input.isKeyPressed(translateKey(direction));
    }


    //Returns the actual key that the direction refers to
    private int translateKey(Direction direction){
        return map.get(direction);
    }


    //Maps all direction with their corresponding key
    private void initiateDirection(){
        map = new HashMap<Direction,Integer>();

        map.put(Direction.P1LEFT,Input.Keys.LEFT);
        map.put(Direction.P1RIGHT,Input.Keys.RIGHT);
        map.put(Direction.P1DIVE,Input.Keys.DOWN);
        map.put(Direction.P1JUMP,Input.Keys.UP);
        map.put(Direction.P1ATTACK,Input.Keys.M);
        map.put(Direction.P2LEFT,Input.Keys.A);
        map.put(Direction.P2RIGHT,Input.Keys.D);
        map.put(Direction.P2DIVE,Input.Keys.S);
        map.put(Direction.P2JUMP,Input.Keys.W);
        map.put(Direction.P2ATTACK, Input.Keys.Z);
        map.put(Direction.P1STOP,Input.Keys.F);
        map.put(Direction.P2STOP,Input.Keys.G);
        map.put(Direction.PAUSE,Input.Keys.ESCAPE);
        map.put(Direction.SELECT, Input.Keys.ENTER);
    }
}
