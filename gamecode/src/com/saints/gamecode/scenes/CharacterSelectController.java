package com.saints.gamecode.scenes;

import com.saints.gamecode.CharacterFactory;
import com.saints.gamecode.Direction;
import com.saints.gamecode.gameobjects.characters.Character;
import com.saints.gamecode.interfaces.IGraphics;
import com.saints.gamecode.interfaces.IKeyInput;

public class CharacterSelectController extends Scene{

    private final IKeyInput input;
    private final IGraphics graphics;
    private Direction [] directions;
    private String char1, char2;

    public CharacterSelectController(IKeyInput input, IGraphics graphics){
        this.input = input;
        this.graphics = graphics;
        initiateInputArray();
    }

    public void update(float delta) {
        checkInput();
        char1 = "Smurf";
        char2 = "Smurf";
        firePropertyChange("characters",null,null);
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

    public Character getPlayer1(){
        return CharacterFactory.createCharacter(char1);
    }

    public Character getPlayer2(){
        return CharacterFactory.createCharacter(char2);
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
