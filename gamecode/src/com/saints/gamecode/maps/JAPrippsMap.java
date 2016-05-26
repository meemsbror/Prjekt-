package com.saints.gamecode.maps;

import com.saints.gamecode.Background;
import com.saints.gamecode.PlatformFactory;
import com.saints.gamecode.Position;
import com.saints.gamecode.gameobjects.Platform;

public class JAPrippsMap extends Map {
    public JAPrippsMap() {
        super(new Background("assets/pictures/UmpMap.jpg"));
        setPlatformList(PlatformFactory.createPlatform("JAPrippsMap"));
    }
    public String getString(){
        return "UmpMap";
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
