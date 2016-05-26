package com.saints.gamecode.maps;

import com.saints.gamecode.Background;
import com.saints.gamecode.PlatformFactory;
import com.saints.gamecode.Position;
import com.saints.gamecode.gameobjects.items.Platform;
import com.saints.gamecode.interfaces.IEntity;

public class JAPrippsMap extends Map {
    public JAPrippsMap(String background, Platform platform) {
        super(new Background("assets/pictures/SandboxMap2.png"));
        addPlatformList(PlatformFactory.createPlatform("JAPrippsMap"));
    }

    @Override
    public String toString() {
        return "JAPrippsMap";
    }

    @Override
    public void setPosition(float x, float y) {

    }

    @Override
    public Position getPosition() {
        return null;
    }
}
