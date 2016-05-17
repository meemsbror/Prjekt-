package com.saints.gamecode.scenes;

import com.saints.gamecode.CharacterFactory;
import com.saints.gamecode.CharacterPanel;
import com.saints.gamecode.Direction;
import com.saints.gamecode.Position;
import com.saints.gamecode.gameobjects.characters.Character;
import com.saints.gamecode.interfaces.IGraphics;
import com.saints.gamecode.interfaces.IKeyInput;


public class CharacterSelectController extends Scene{

    private final IKeyInput input;
    private final IGraphics graphics;
    private Direction [] directions;
    private String char1, char2;
    private CharacterPanel characterPanels[][];
    private Position p1Pos, p2Pos;

    public CharacterSelectController(IKeyInput input, IGraphics graphics){
        this.input = input;
        this.graphics = graphics;
        initiateInputArray();
        initiatePositions();
    }

    public void update(float delta) {
        checkInput();
        /*
        Need characterPanels first!
        updateActivePanels();
        */
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

    //Iterates all panels and activates the ones selected
    private void updateActivePanels(){
        for(int i = 0; i<characterPanels.length; i++){
            for(int j=0; j<characterPanels[i].length; j++){
                CharacterPanel characterPanel = characterPanels[i][j];

                characterPanel.setPlayer1Selected(((int)p1Pos.getY() == i && (int)p1Pos.getX() == j));
                characterPanel.setPlayer2Selected(((int)p2Pos.getY() == i && (int)p2Pos.getX() == j));
            }
        }
    }

    //tells the position to update depending on what the input is
    private void keyPressed(Direction dir){

        switch (dir){
            case P1JUMP:
                moveUP(p1Pos);
                break;
            case P1LEFT:
                moveLeft(p1Pos);
                break;
            case P1RIGHT:
                moveRight(p1Pos);
                break;
            case P1DIVE:
                moveDown(p1Pos);
                break;

            case P2JUMP:
                moveUP(p2Pos);
                break;
            case P2LEFT:
                moveLeft(p2Pos);
                break;
            case P2RIGHT:
                moveRight(p2Pos);
                break;
            case P2DIVE:
                moveDown(p2Pos);
                break;
        }
    }

    private void moveUP(Position pos){
        if(pos.getY()>0){
            pos.move(0,-1);
        }
    }

    private void moveDown(Position pos){
        int height = characterPanels.length;
        if(pos.getY()<height-1){
            if(!((int)pos.getX() > characterPanels[(int)pos.getY() + 1].length - 1)){
                pos.move(0,1);
            }
        }
    }

    private void moveRight(Position pos){
        if(pos.getX()<characterPanels[(int)pos.getY()].length-1){
            pos.move(1,0);
        }
    }

    private void moveLeft(Position pos){
        if(pos.getX()>0){
            pos.move(-1,0);
        }
    }

    public Character getPlayer1(){
        return CharacterFactory.createCharacter(char1);
    }

    public Character getPlayer2(){
        return CharacterFactory.createCharacter(char2);
    }

    private void initiatePositions(){
        p1Pos = new Position(0,0);
        p2Pos = new Position(0,0);
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
