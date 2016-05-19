package com.saints.gamecode.gameobjects.items;

import com.saints.gamecode.AnimationObject;
import com.saints.gamecode.Position;
import com.saints.gamecode.gameobjects.GameObject;


public class Platform extends GameObject {
    private static int x; // Straight line to build platform to stand on.
    private static int width;  // Have to be arrayList/polygontåg if we want to make a
    private static int y;      // platform more complex than a line.
    private static int height;

    public Platform (int x, int y, int width, int height){

        super(width,height, new AnimationObject("hehe", 0,0,0));
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }


    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public int getY() {
        return y;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setPosition(int x, int y) {

    }
}
