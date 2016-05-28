package Entities.gameobjects;

import com.saints.gamecode.AnimationObject;


public class Platform extends GameObject {
    private int x; // Straight line to build platform to stand on.
    private int width;  // Have to be arrayList/polygontåg if we want to make a
    private int y;      // platform more complex than a line.
    private int height;

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
    public void setPosition(float x, float y) {

    }
}
