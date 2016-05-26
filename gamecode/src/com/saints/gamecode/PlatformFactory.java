package com.saints.gamecode;

import com.saints.gamecode.gameobjects.Platform;

import java.util.ArrayList;
import java.util.List;

public class PlatformFactory {
    public static List<Platform> platforms = new ArrayList<Platform>();

    public static Platform createPlatform(Integer x, Integer y, Integer width, Integer height){
        return new Platform(x,y,width,height);


    }


    public static Platform createPlatform(){
        return new Platform(270,138,680,10);


    }

    public static List<Platform> createPlatform(String name){
        platforms.clear();
        switch (name){
            case "JAPrippsMap" :
                platforms.add(new Platform(50,50,1000,50));
                return platforms;
            case "SandboxMap" :
                platforms.add(new Platform(270,138,680,10));
                return platforms;
            case "UmpMap" :
                platforms.add(new Platform(200,138,730,10));
                return platforms;
            default:
                platforms.add(new Platform(50,50,1000,50));
                return platforms;
        }
    }
}