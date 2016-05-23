package com.saints.gamecode.scenes;

import com.saints.gamecode.CharacterFactory;
import com.saints.gamecode.CharacterPanel;
import com.saints.gamecode.Direction;
import com.saints.gamecode.Position;
import com.saints.gamecode.gameobjects.characters.Character;
import com.saints.gamecode.interfaces.IGraphics;
import com.saints.gamecode.interfaces.IKeyInput;

import java.util.ArrayList;


public class CharacterSelectController extends Scene{

    private final IKeyInput input;
    private final IGraphics graphics;
    private Direction [] directions;
    private String char1, char2;
    private CharacterPanel characterPanels[][];
    private Position p1Pos, p2Pos;
    private CharacterPanel p1Panel, p2Panel;


    public CharacterSelectController(IKeyInput input, IGraphics graphics){
        this.input = input;
        this.graphics = graphics;
        initiateInputArray();
        initiatePositions();
        initiatePanels();
    }

    public void update(float delta) {
        while(true){
            if()
        }
        checkInput();
        setPanelPositions();
        updateActivePanels();
        graphics.update(delta, characterPanels);
    }

    //Checks all diferent input keys and if they are pressed
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

            case SELECT:
                charactersSelected();
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

    //Sets the characters as selected and tells the listeners that they are ready to be fetched
    private void charactersSelected(){
        char1 = characterPanels[(int)p1Pos.getY()][(int)p1Pos.getX()].getName();
        char2 = characterPanels[(int)p2Pos.getY()][(int)p2Pos.getX()].getName();

        firePropertyChange("Characters selected",null,null);
    }


    public Character getPlayer1(){
        return CharacterFactory.createCharacter(char1, true);
    }

    public Character getPlayer2(){
        return CharacterFactory.createCharacter(char2, false);
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
                    Direction.P2DIVE,
                    Direction.SELECT};
    }

    private void initiatePanels(){
        characterPanels = new CharacterPanel[][] {
                {new CharacterPanel("assets/pictures/SmurfPanel.png","Smurf"), new CharacterPanel("assets/pictures/LuckyPanel.png", "Lucky")}
        };

        p1Panel = new CharacterPanel("assets/pictures/P1Panel.png", "P1");
        p2Panel = new CharacterPanel("assets/pictures/P2Panel.png", "P2");

        setPanelPositions();
        addTextures();
    }

    public void addTextures(){
        graphics.addTexture(p1Panel.getImgPath());
        graphics.addTexture(p2Panel.getImgPath());

        for(int i = 0; i < characterPanels.length; i++){
            for (int j = 0; j < characterPanels[i].length; j++){
                System.out.println(characterPanels[i][j].getImgPath());
                graphics.addTexture(characterPanels[i][j].getImgPath());
            }
        }

    }

    private void setPanelPositions(){
        int screenHeight = graphics.getScreenHeight();
        int screenWidth = graphics.getScreenWidth();
        int rows = characterPanels.length;
        int panelsHeight = 225*rows;
        int ySpace = (screenHeight-panelsHeight)/rows;

        for(int i = 0; i<rows; i++){
            int panelsWidth = 0;
            for(int j = 0; j < characterPanels[i].length; j++){
                panelsWidth += characterPanels[i][j].getWidth();
            }
            int xSpace = (screenWidth-panelsWidth)/(characterPanels[i].length + 1);

            int xPos = xSpace;
            int yPos = ySpace*(i + 1) + 225*(i);


            for(int j = 0; j< characterPanels[i].length; j++){

                characterPanels[i][j].setPosition(xPos, yPos);
            }
        }
    }
}
