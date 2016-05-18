package com.saints.gamecode;

public class CharacterPanel {

    private boolean player1Selected, player2Selected;

    private String imgPath;

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

    public void setImage(String imgPath){
        this.imgPath = imgPath;
    }

    public String getImage(){
        return this.imgPath;
    }
}
