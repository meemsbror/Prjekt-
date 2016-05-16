package com.saints.gamecode.gameobjects.characters.attacks;

import com.saints.gamecode.gameobjects.GameObject;

public class StraightAttack extends GameObject {

    private String imgPath;

    public StraightAttack(int x, int y, int width, int height, String imgPath) {
        super(x, y, width, height);
        this.imgPath = imgPath;
    }

    @Override
    public String getSpriteSheet() {
        return imgPath;
    }
}
