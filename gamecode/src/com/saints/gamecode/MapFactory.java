package com.saints.gamecode;

import com.saints.gamecode.maps.JAPrippsMap;
import com.saints.gamecode.maps.Map;

public class MapFactory {

    public Map createMap(String map){
        return new JAPrippsMap();
    }
}
