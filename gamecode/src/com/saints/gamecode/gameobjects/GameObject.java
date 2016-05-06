package com.saints.gamecode.gameobjects;

import com.saints.gamecode.State;
import com.saints.gamecode.Position;
import com.saints.gamecode.Vector2D;
import com.saints.gamecode.gameobjects.items.Platform;

public abstract class GameObject {

    //The position of the object counted from bottom left of the window
    private Position pos;

    //Set to true if there is no solid ground under the object
    private boolean isAirborne;

    //A vector that describes the direction and speed of the object
    private Vector2D movement;

    //the width and height of the object
    private int width,height;

    //Image
    private String imgPath;

    public GameObject(int x, int y, int width, int height){
        pos = new Position(x,y);
        this.width = width;
        this.height = height;
        movement = new Vector2D();
    }


    //Returns the x-coordinate
    public Position getPosition(){
        return pos;
    }

    //Moves the object a set amount both along the y and x-axis
    public void move(float dx, float dy){
        pos.move(dx, dy);
    }

    public void setPosition(float x, float y){
        pos.setX(x);
        pos.setY(y);
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

    public boolean collide(GameObject object) {
        if (pos.getX() + width < object.getPos().getX() || object.getPos().getX() + object.getWidth() < pos.getX()
                || pos.getY() + height < object.getPos().getY() || object.getPos().getY() + object.getHeight() < pos.getY()) {
            return false;
        } else {
            return true;
        }
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

    public String getImgPath(){
        return imgPath;
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



    @Override
    public String toString() {
        return "GameObject{" +
                "pos=" + pos.toString() +
                '}';
    }

    public int hashCode() {
        int result = pos != null ? pos.hashCode() : 0;
        result = 31 * result + width;
        result = 31 * result + height;
        result = 31 * result + (imgPath != null ? imgPath.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameObject that = (GameObject) o;

        if (width != that.width) return false;
        if (height != that.height) return false;
        if (pos != null ? !pos.equals(that.pos) : that.pos != null) return false;
        return !(imgPath != null ? !imgPath.equals(that.imgPath) : that.imgPath != null);
    }
}
