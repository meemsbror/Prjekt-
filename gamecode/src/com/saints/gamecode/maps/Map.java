package com.saints.gamecode.maps;


import com.saints.gamecode.Background;
import com.saints.gamecode.Position;
import com.saints.gamecode.gameobjects.items.Platform;
import com.saints.gamecode.interfaces.IEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class Map implements IEntity {
    private final float x = 0;
    private final float y = 0;
    Background background;
    List<Platform> platformList = new ArrayList<Platform>();

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public List<Platform> getPlatformList() {

        return platformList;
    }

    public void addPlatformList(Platform platform) {
        platformList.add(platform);
    }


    public Map(Background background){
        this.background = background;
    }
    @Override
    public String toString() {
        return "Map";
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
