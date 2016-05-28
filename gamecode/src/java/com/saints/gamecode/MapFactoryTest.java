package com.saints.gamecode;

import com.saints.gamecode.Entities.maps.JAPrippsMap;
import com.saints.gamecode.Entities.maps.Map;
import com.saints.gamecode.Entities.maps.SandboxMap;
import com.saints.gamecode.Entities.maps.UmpMap;
import org.junit.Test;

import static org.junit.Assert.*;
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