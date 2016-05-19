package com.saints.gamecode.maps;

import com.saints.gamecode.gameobjects.items.Platform;
import com.saints.gamecode.interfaces.IEntity;

public class SandboxMap extends Map {
    //Should implement sandbox.png and some kind of platform
    public SandboxMap(IEntity background, Platform platform) {
        super(background, platform);
    }
    @Override
    public String toString() {
        return "SandboxMap";
    }
}
