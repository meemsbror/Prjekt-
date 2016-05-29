package com.saints.gamecode.utils;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector2D vector2D = (Vector2D) o;

        if (Float.compare(vector2D.getX(), getX()) != 0) return false;
        return Float.compare(vector2D.getY(), getY()) == 0;

    }

    @Override
    public int hashCode() {
        int result = (getX() != +0.0f ? Float.floatToIntBits(getX()) : 0);
        result = 31 * result + (getY() != +0.0f ? Float.floatToIntBits(getY()) : 0);
        return result;
    }
}