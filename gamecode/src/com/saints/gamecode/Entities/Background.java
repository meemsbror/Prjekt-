package com.saints.gamecode.Entities;

import com.saints.gamecode.utils.Position;
import com.saints.gamecode.interfaces.IEntity;


public class Background implements IEntity {

    private String imgPath;

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Background (String imgPath){
        this.imgPath = imgPath;

    }

    @Override
    public void setPosition(float x, float y) {

    }

    @Override
    public Position getPosition() {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

}
