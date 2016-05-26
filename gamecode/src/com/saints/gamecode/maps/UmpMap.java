package com.saints.gamecode.maps;


import com.saints.gamecode.Background;
import com.saints.gamecode.PlatformFactory;

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