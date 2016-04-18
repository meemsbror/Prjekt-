package com.saints.gamecode.gameobjects.items;

import com.saints.gamecode.gameobjects.GameObject;

public abstract class Item extends GameObject{

    int durability;


    public Item (int x, int y, int width, int height){
        super(x,y,width,height);
    }

}
