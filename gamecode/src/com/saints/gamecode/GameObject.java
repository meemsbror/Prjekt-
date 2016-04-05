package com.saints.gamecode;

public abstract class GameObject {

    //The position of the object counted from bottom left of the window
    Position pos;
    //The direction of the object
    boolean facingRight;

    //the width and height of the object
    int width,height;


    public GameObject(int width, int height){
        this(0,0,width,height);
    }

    public GameObject(int x, int y, int width, int height){
        pos = new Position(x,y);
        this.width = width;
        this.height = height;
    }
    //Returns the x-coordinate
    public Position getPosition(){
        return pos;
    }

    //Moves the object a set amount both along the y and x-axis
    public void move(int dx, int dy){
        pos.move(dx,dy);
    }
}
