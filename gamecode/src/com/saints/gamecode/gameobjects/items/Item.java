package com.saints.gamecode.gameobjects.items;

import com.saints.gamecode.AnimationObject;
import com.saints.gamecode.gameobjects.GameObject;

public abstract class Item extends GameObject{

    int durability;


    public Item (int x, int y, int width, int height, AnimationObject animationObject){
        super(x,y,width,height, animationObject);
    }

    public abstract float getDuration();
}
