package com.saints.gamecode;

public class CharacterPanel {

    private boolean player1Selected, player2Selected;

    private final String imgPath, characterName;

    public CharacterPanel(String imgPath, String characterName){
        this.imgPath = imgPath;
        this.characterName = characterName;
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
}