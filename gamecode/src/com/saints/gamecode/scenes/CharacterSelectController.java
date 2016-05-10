package com.saints.gamecode.scenes;

import com.saints.gamecode.Direction;
import com.saints.gamecode.interfaces.IGraphics;
import com.saints.gamecode.interfaces.IKeyInput;
import com.saints.gamecode.interfaces.IScene;

public class CharacterSelectController implements IScene{

    private final IKeyInput input;
    private final IGraphics graphics;
    private Direction [] directions;

    public CharacterSelectController(IKeyInput input, IGraphics graphics){
        this.input = input;
        this.graphics = graphics;
        initiateInputArray();
    }

    public void update(float delta) {
        checkInput();
    }

    private void checkInput(){
        for(Direction dir: directions){
            if(input.isKeyPressed(dir)){
                keyPressed(dir);
            }
        }

    }

    private void keyPressed(Direction dir){

        switch (dir){
            case P1JUMP:
                break;
            case P1LEFT:
                break;
            case P1RIGHT:
                break;
            case P1DIVE:
                break;

            case P2JUMP:
                break;
            case P2LEFT:
                break;
            case P2RIGHT:
                break;
            case P2DIVE:
                break;
            default:
                break;
        }
    }

    private void initiateInputArray(){
        directions = new Direction [] {Direction.P1DIVE,
                    Direction.P1RIGHT,
                    Direction.P1LEFT,
                    Direction.P1RIGHT,
                    Direction.P1JUMP,
                    Direction.P2RIGHT,
                    Direction.P2LEFT,
                    Direction.P2JUMP,
                    Direction.P2DIVE};
    }
}
