package com.saints.gamecode;

public class Position implements Cloneable {

    private int x, y;

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
        int result = getX();
        result = 31 * result + getY();
        return result;
    }

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {

        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }

    public Object clone(){
        try{
            return super.clone();
        }catch(CloneNotSupportedException e1){
            //never invoked since this implements cloneable
            return null;
        }
    }
}
