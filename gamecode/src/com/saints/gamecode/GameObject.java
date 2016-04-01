package com.saints.gamecode;

public abstract class GameObject {

    //The position of the object counted from bottom left of the window
    int x;
    int y;

    //The direction of the object
    boolean facingRight;

    public GameObject(int x, int y){
        this.x=x;
        this.y=y;
    }
    //Returns the x-coordinate
    public int getX(){
        return x;
    }

    //Returns the y-coordinate
    public int getY(){
        return y;
    }

    //Moves the object a set amount both along the y and x-axis
    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }
}
