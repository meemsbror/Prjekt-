package com.saints.gamecode.Entities.maps;

import com.saints.gamecode.Entities.Background;
import com.saints.gamecode.PlatformFactory;
import com.saints.gamecode.Position;

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
