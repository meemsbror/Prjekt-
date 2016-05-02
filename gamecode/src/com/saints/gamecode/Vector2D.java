package com.saints.gamecode;

public class Vector2D implements Cloneable {

    private float x,y;

    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    //Adds another vector to this vector
    public void addVector(Vector2D other){
        this.x += other.x;
        this.y += other.y;
    }

    public void multiplyVector(float multiplication){
        this.x *= multiplication;
        this.y *= multiplication;
    }

    //Getter for x
    public float getX() {
        return x;
    }

    //Getter for y
    public float getY() {
        return y;
    }

    //Sets the X value to zero
    public void resetX(){
        this.x = 0;
    }

    //Sets the Y value to zero
    public void resetY(){
        this.y = 0;
    }

    //Gets the "length" of the vector (The magnitude)
    public float getMagnitude(){
        return (float)(Math.sqrt(x*x+y*y));
    }
    @Override
    public Object clone(){
        return new Vector2D(x,y);
    }
}
