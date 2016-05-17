package com.saints.gamecode.gameobjects.characters.attacks;

import com.saints.gamecode.gameobjects.GameObject;

public class StraightAttack extends GameObject {

    private String spritePath = "assets/pictures/straightAttack.png";

    public String getSpritePath() {
        return spritePath;
    }

    public void setSpritePath(String spritePath) {
        this.spritePath = spritePath;
    }

    public StraightAttack(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}
