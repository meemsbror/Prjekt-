package com.saints.gamecode.gameobjects.characters.attacks;

import com.saints.gamecode.gameobjects.GameObject;

/**
 * Created by admin on 2016-04-15.
 */
public class StraightAttack extends GameObject {

    public StraightAttack(int x, int y, int width, int height, String imgPath) {
        super(x, y, width, height);
        setImgPath(imgPath);
    }
    public GameObject use(){
        return this;
    }
}
