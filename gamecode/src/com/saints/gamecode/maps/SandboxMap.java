package com.saints.gamecode.maps;

import com.saints.gamecode.Background;
import com.saints.gamecode.PlatformFactory;
import com.saints.gamecode.Position;
import com.saints.gamecode.gameobjects.items.Platform;

import java.util.ArrayList;
import java.util.List;

public class SandboxMap extends Map {
    private float x;
    private float y;

    //Should implement sandbox.png and some kind of platform
    public SandboxMap() {
        super(new Background("assets/pictures/SandboxMap2.png"));
        addPlatformList(PlatformFactory.createPlatform("SandboxMap"));
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
