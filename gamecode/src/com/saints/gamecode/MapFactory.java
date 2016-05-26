package com.saints.gamecode;

import com.saints.gamecode.maps.*;
import com.saints.gamecode.maps.Map;
import com.saints.gamecode.maps.JAPrippsMap;
import com.saints.gamecode.maps.SandboxMap;

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
