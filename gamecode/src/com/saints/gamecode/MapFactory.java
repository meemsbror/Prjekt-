package com.saints.gamecode;

import Entities.maps.*;
import Entities.maps.Map;
import Entities.maps.JAPrippsMap;
import Entities.maps.SandboxMap;

public class MapFactory {

    public static Map createMap(String map){
        switch (map){
            case "JAPrippsMap" :
                return new JAPrippsMap();
            case "SandboxMap" :
                return new SandboxMap();
            case "UmpMap" :
                return new UmpMap();
            default:
                return new SandboxMap();
        }
    }


    public static String [] getMaps(){
        return new String [] {"JAPripps", "Sandbox"};
    }
}
