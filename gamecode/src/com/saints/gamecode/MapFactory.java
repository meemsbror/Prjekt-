package com.saints.gamecode;

import com.saints.gamecode.gameobjects.items.Platform;
import com.saints.gamecode.maps.*;
import com.saints.gamecode.maps.Map;
import com.saints.gamecode.maps.JAPrippsMap;
import com.saints.gamecode.maps.SandboxMap;

public class MapFactory {

    public static Map createMap(String map){
        switch (map){
            case "JAPrippsMap" :
                return new JAPrippsMap("assets/pictures/saints.of.chalmers-sandbox.png",
                        PlatformFactory.createPlatform(map));
            case "SandboxMap" :
                return new SandboxMap("assets/pictures/saints.of.chalmers-sandbox.png",
                        PlatformFactory.createPlatform(map));
            case "UmpMap" :
                return new SandboxMap("assets/pictures/RumpMap.png",
                        PlatformFactory.createPlatform(map));
            default:
                return new SandboxMap("assets/pictures/saints.of.chalmers-sandbox.png",
                        PlatformFactory.createPlatform(map));
        }
    }


    public static String [] getMaps(){
        return new String [] {"JAPripps", "Sandbox"};
    }
}
