package com.saints.gamecode.gameobjects.items;

import com.saints.gamecode.Position;
import com.saints.gamecode.gameobjects.GameObject;

/**
 * Created by ludvig on 2016-05-02.
 */
public class Platform extends GameObject {
    private static int x; // Straight line to build platform to stand on.
    private static int width;  // Have to be arrayList/polygontåg if we want to make a
    private static int y;      // platform more complex than a line.
    private static int height;

    public Platform (int x, int y, int width, int height){
        super(x, y, width, height);
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }

    public void setPlatform(int x, int y, int width, int height){
        //pos = new Position(x,y);
        /*this.x = x;
        this.width = width;
        this.y = y;
        this.height = height;*/

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
}
