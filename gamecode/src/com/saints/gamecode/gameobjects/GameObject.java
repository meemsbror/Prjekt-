package com.saints.gamecode.gameobjects;

import com.saints.gamecode.AnimationObject;
import com.saints.gamecode.State;
import com.saints.gamecode.Position;
import com.saints.gamecode.Vector2D;
import com.saints.gamecode.gameobjects.items.Platform;


public abstract class GameObject {

    //The position of the object counted from bottom left of the window
    private Position pos,oldPos;

    //Set to true if there is no solid ground under the object
    private boolean isAirborne;

    //A vector that describes the direction and speed of the object
    private Vector2D movement;

    //the width and height of the object
    private int width,height;

    //Image
    private AnimationObject animationObject;

    public GameObject(int width, int height, AnimationObject animationObject){
        pos = new Position(0,0);
        oldPos = new Position(0,0);
        this.width = width;
        this.height = height;
        this.animationObject = animationObject;
        movement = new Vector2D();
    }


    //Returns the x-coordinate
    public Position getPosition(){
        return pos;
    }

    //Moves the object a set amount both along the y and x-axis
    public void move(float dx, float dy){
        saveOldPos();
        pos.move(dx, dy);
    }

    public void setPosition(float x, float y){
        saveOldPos();
        pos.setX(x);
        pos.setY(y);
    }
    public void setPosition(Position pos){
        this.setPosition(pos.getX(), pos.getY());
    }

    public void revertHorizontalPosition(){
        pos.setX(oldPos.getX());
    }

    public void revertVerticalPosition(){
        pos.setY(oldPos.getY());
    }

    private void saveOldPos(){
        oldPos.setX(pos.getX());
        oldPos.setY(pos.getY());
    }

    public Position getPos() {
        return (Position)pos.clone();
    }

    public Position getOldPos(){
        return (Position)oldPos.clone();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    //Adds a vector to the movement vector to change the direction of the object.
    public void changeDirection(Vector2D vector){
        movement.addVector(vector);
    }

    public void setHorizontalSpeed(float x){
        movement.setX(x);
    }

    public void setVerticalSpeed(float y){
        movement.setY(y);
    }

    public void resetHorizontalSpeed(){
        movement.resetX();
    }

    public void resetVerticalSpeed(){
        movement.resetY();
    }

    //Set if the object is on solid ground or not
    public void setAirborne(boolean isAirborne){
        this.isAirborne = isAirborne;
    }

    //Returns the isAirborne variable which says if the object is on solid ground or not.
    public boolean isAirborne(){
        return isAirborne;
    }

    //Returns the vertical speed of the object
    public float getVerticalSpeed(){
        return movement.getY();
    }

    //Returns the horizontal speed of the object
    public float getHorizontalSpeed(){
        return movement.getX();
    }


    public boolean onPlatform(Platform platform){
     //if ( ("X for any part of object"=="X for any part of platform")
     // AND ("Y for bottom of object"=="Y for top of platform") ) {return true}
     if ( (!(pos.getX()-getWidth()<platform.getX())||(platform.getX()+getWidth()<pos.getX())) &&
             (pos.getY()<platform.getY()) && (pos.getY()>platform.getY()-50)) { //marginal is 50
                return true;
        }else{
            return false;
        }
    }
    public AnimationObject getAnimationObject(){
        return animationObject;
    }



    @Override
    public String toString() {
        return "GameObject{" +
                "pos=" + pos.toString() +
                '}';
    }
}
