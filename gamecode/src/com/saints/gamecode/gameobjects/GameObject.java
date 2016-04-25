package com.saints.gamecode.gameobjects;

import com.saints.gamecode.State;
import com.saints.gamecode.Position;

public abstract class GameObject {

    //The position of the object counted from bottom left of the window
    Position pos;

    //the width and height of the object
    int width,height;

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
        pos.move(dx, dy);
    }

    public Position getPos() {
        return (Position)pos.clone();
    }


    public int getHeight() {
        return height;
    }

    public int getWidth() {

        return width;
    }

    public boolean collide(GameObject object){
        if(pos.getX()+width<object.getPos().getX() || object.getPos().getX()+object.getWidth()<pos.getX()
                || pos.getY()+height<object.getPos().getY() || object.getPos().getY()+object.getHeight()<pos.getY()){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String toString() {
        return "GameObject{" +
                "pos=" + pos.toString() +
                '}';
    }
}
