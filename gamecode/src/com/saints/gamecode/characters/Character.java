package com.saints.gamecode.characters;

import com.saints.gamecode.GameObject;

public abstract class Character extends GameObject {

    //arbitrary 100
    private int hitPoints = 100;

    public Character(int width, int height){
        this(0,0,width,height);
    }
    public Character(int x,int y, int width, int height){
        super(x,y,width,height);
    }

}
