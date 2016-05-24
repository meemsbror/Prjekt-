package com.saints.gamecode;

import com.saints.gamecode.gameobjects.items.Platform;

public class PlatformFactory {

    public static Platform createPlatform(Integer x, Integer y, Integer width, Integer height){
        return new Platform(x,y,width,height);


    }


    public static Platform createPlatform(){
        return new Platform(50,50,1000,50);


    }

    public static Platform createPlatform(String name){
        switch (name){
            case "JAPrippsMap" :
                return new Platform(50,50,1000,50);
            case "SandboxMap" :
                return new Platform(270,138,680,10);
            default:
                return new Platform(50,50,1000,50);
        }
    }
}