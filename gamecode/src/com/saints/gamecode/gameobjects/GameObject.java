package com.saints.gamecode.gameobjects;

import com.saints.gamecode.Position;

public abstract class GameObject {

    //The position of the object counted from bottom left of the window
    Position pos;

    //the width and height of the object
    int width,height;

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
        pos.move(dx, dy);
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
