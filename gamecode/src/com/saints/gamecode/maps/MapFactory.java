package com.saints.gamecode.maps;

public class MapFactory {

    public Map createMap(String map){
        return new JAPrippsMap();
    }
}
