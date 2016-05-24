package com.saints.gamecode.maps;

import com.saints.gamecode.Position;
import com.saints.gamecode.gameobjects.items.Platform;
import com.saints.gamecode.interfaces.IEntity;

public class SandboxMap extends Map {
    private float x;
    private float y;
    //Should implement sandbox.png and some kind of platform
    public SandboxMap(String background, Platform platform) {
        super(background, platform);
    }
    @Override
    public String toString() {
        return "SandboxMap";
    }

    @Override
    public void setPosition(float x, float y) {

    }

    @Override
    public Position getPosition() {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
