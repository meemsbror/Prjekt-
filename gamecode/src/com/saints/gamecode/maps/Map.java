package com.saints.gamecode.maps;


import com.saints.gamecode.gameobjects.items.Platform;
import com.saints.gamecode.interfaces.IEntity;

public abstract class Map {

    public Map(IEntity background, Platform platform){

    }
    @Override
    public String toString() {
        return "Map";
    }
}
