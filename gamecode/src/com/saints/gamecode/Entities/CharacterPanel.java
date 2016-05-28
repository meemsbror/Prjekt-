package com.saints.gamecode.Entities;

import com.saints.gamecode.Position;
import com.saints.gamecode.interfaces.IEntity;

public class CharacterPanel implements IEntity{

    private boolean player1Selected, player2Selected;

    private final String imgPath, characterName;

    private Position pos;

    private int width = 300;
    private int height = 275;

    public CharacterPanel(String imgPath, String characterName){
        this.imgPath = imgPath;
        this.characterName = characterName;
        pos = new Position(0,0);
    }

    public boolean isPlayer1Selected() {
        return player1Selected;
    }

    public void setPlayer1Selected(boolean player1Selected) {
        this.player1Selected = player1Selected;
    }

    public boolean isPlayer2Selected() {
        return player2Selected;
    }

    public void setPlayer2Selected(boolean player2Selected) {
        this.player2Selected = player2Selected;
    }

    public String getName(){
        return characterName;
    }

    @Override
    public void setPosition(float x, float y){
        pos.setX(x);
        pos.setY(y);
    }

    @Override
    public Position getPosition(){
        return (Position)pos.clone();
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public String getImgPath(){
        return imgPath;
    }
}