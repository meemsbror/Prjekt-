package com.saints.gamecode;

import org.junit.Test;

import static org.junit.Assert.*;

public class Vector2DTest {

    private final Vector2D vector = new Vector2D(0,0);

    @Test
    public void addVector() throws Exception {

        float x = vector.getX();
        float y = vector.getY();

        vector.addVector(new Vector2D());

    }

    @Test
    public void multiplyVector() throws Exception {

    }

    @Test
    public void resetX() throws Exception {

    }

    @Test
    public void resetY() throws Exception {

    }

    @Test
    public void getMagnitude() throws Exception {

    }

    @Test
    public void cloneTest() throws Exception {

    }

    private float random(){
        return (float)Math.random();
    }

}