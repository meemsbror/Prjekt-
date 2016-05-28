package com.saints.gamecode.Entities.maps;


import com.saints.gamecode.Entities.Background;
import com.saints.gamecode.utils.PlatformFactory;

public class UmpMap extends Map {
    private float x;
    private float y;
    //Should implement sandbox.png and some kind of platform
    public UmpMap() {
        super(new Background("assets/pictures/UmpMap.jpg"));
        setPlatformList(PlatformFactory.createPlatform("UmpMap"));
    }
    public String getString(){
        return "UmpMap";
    }

}