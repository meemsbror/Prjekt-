package com.saints.gamecode;

public abstract class Character extends GameObject{

    //arbitrary 100
    private int hitPoints = 100;

    public Character(int x,int y){
        super(x,y);
    }
    public void move() {

    }
}
