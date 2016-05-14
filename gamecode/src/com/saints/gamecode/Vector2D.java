package com.saints.gamecode;

//2DVector for handling directions of gameobjects
public class Vector2D implements Cloneable {

    //the directions, x is horizontal and y is vertical
    private float x,y;

    //Creates an empty vector
    public Vector2D(){
        this(0,0);
   }

    //Creates a vector with specified start values
    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    //Adds another vector to this vector
    public void addVector(Vector2D other){
        this.x += other.x;
        this.y += other.y;
    }

    //Multiply this vector with a scalar
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

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
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
