package com.saints.gamecode.Entities.gameobjects.items;

import com.saints.gamecode.utils.AnimationObject;
import com.saints.gamecode.Entities.gameobjects.GameObject;

public abstract class Item extends GameObject{


    public Item (float x, float y, int width, int height, AnimationObject animationObject){
        super(width,height, animationObject);
        setPosition(x,y);
    }

}
