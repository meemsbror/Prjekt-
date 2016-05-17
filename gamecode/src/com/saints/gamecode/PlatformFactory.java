package com.saints.gamecode;

import com.saints.gamecode.gameobjects.items.Platform;

public class PlatformFactory {


    public static Platform createPlatform(){
        return new Platform(10,50,1000,50);


    }
}