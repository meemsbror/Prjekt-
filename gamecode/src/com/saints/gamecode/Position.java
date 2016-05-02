package com.saints.gamecode;

public class Position implements Cloneable {

    private float x, y;

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position = (Position) o;

        if (getX() != position.getX()) return false;
        return getY() == position.getY();

    }

    @Override
    public int hashCode() {
        int result = (getX() != +0.0f ? Float.floatToIntBits(getX()) : 0);
        result = 31 * result + (getY() != +0.0f ? Float.floatToIntBits(getY()) : 0);
        return result;
    }



    public Position(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {

        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void move(float dx, float dy){
        this.x += dx;
        this.y += dy;
    }

    @Override
    public Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            //Never invoked
        }
        return null;
    }
}
