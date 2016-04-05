package com.saints.gamecode;


import com.badlogic.gdx.graphics.Texture;

public abstract class GameObject {

    //The position of the object counted from bottom left of the window
    private Position pos;
    //The direction of the object
    private boolean facingRight;

    //the width and height of the object
    private int width,height;

    //Image
    String imgPath;

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

    //Sets image
    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }


    public Position getPos() {
        return pos;
    }
}
