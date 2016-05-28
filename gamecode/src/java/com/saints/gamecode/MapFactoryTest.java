package com.saints.gamecode;

import com.saints.gamecode.Entities.maps.*;
import org.junit.Test;

public class MapFactoryTest {
    @Test
    public void createMap() throws Exception {

        Map map = MapFactory.createMap("JAPrippsMap");
        assert map instanceof JAPrippsMap;

        map = MapFactory.createMap("SandboxMap");
        assert map instanceof SandboxMap;

        map = MapFactory.createMap("UmpMap");
        assert map instanceof UmpMap;

    }
}