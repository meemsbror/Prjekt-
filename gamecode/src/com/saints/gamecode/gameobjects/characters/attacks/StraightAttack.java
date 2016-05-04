package com.saints.gamecode.gameobjects.characters.attacks;

import com.saints.gamecode.gameobjects.GameObject;

public class StraightAttack extends GameObject {

    public StraightAttack(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public GameObject use(){
        return this;
    }
}
