package com.saints.gamecode.maps;

import com.saints.gamecode.Position;
import com.saints.gamecode.gameobjects.items.Platform;
import com.saints.gamecode.interfaces.IEntity;

public class JAPrippsMap extends Map {
    public JAPrippsMap(String background, Platform platform) {
        super(background, platform);
    }

    @Override
    public String toString() {
        return "JAPrippsMap";
    }



}
