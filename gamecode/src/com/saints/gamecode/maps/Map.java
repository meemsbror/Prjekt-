package com.saints.gamecode.maps;


import com.mygdx.game.LibGDXGraphics;
import com.saints.gamecode.Position;
import com.saints.gamecode.gameobjects.items.Platform;
import com.saints.gamecode.interfaces.IAssetsManager;
import com.saints.gamecode.interfaces.IEntity;

public abstract class Map implements IEntity {
    private final float x = 0;
    private final float y = 0;
    private String mapPath;

    public Map(String background, Platform platform){
        //addTexture
    }
    @Override
    public String toString() {
        return "Map";
    }

    public String getMapPath() {
        return mapPath;
    }

    public void setMapPath(String mapPath) {
        this.mapPath = mapPath;
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
        return 1280;
    }

    @Override
    public int getHeight() {
        return 720;
    }
}
