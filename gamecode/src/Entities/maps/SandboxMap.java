package Entities.maps;

import Entities.Background;
import com.saints.gamecode.PlatformFactory;

public class SandboxMap extends Map {
    private float x;
    private float y;

    //Should implement sandbox.png and some kind of platform
    public SandboxMap() {
        super(new Background("assets/pictures/SandboxMap2.png"));
        setPlatformList(PlatformFactory.createPlatform("SandboxMap"));
    }
    @Override
    public String toString() {
        return "SandboxMap";
    }
}
