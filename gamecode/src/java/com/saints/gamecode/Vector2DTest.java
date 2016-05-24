package com.saints.gamecode;

import org.junit.Test;

import static org.junit.Assert.*;

public class Vector2DTest {


    @Test
    public void addVector() throws Exception {

        Vector2D vector1 = new Vector2D(random(),random());
        Vector2D vector2 = new Vector2D(random(),random());

        float x1 = vector1.getX();
        float y1 = vector1.getY();

        vector1.addVector(vector2);

        assert vector1.getX() == x1 + vector2.getX();
        assert vector1.getY() == y1 + vector2.getY();
    }

    @Test
    public void multiplyVector() throws Exception {

        Vector2D vector = new Vector2D(random(),random());
        float x = vector.getX();
        float y = vector.getY();
        float multi = random();

        vector.multiplyVector(multi);

        assert vector.getX() == x * multi;
        assert vector.getY() == y * multi;
    }

    @Test
    public void resetX() throws Exception {

        Vector2D vector = new Vector2D(random(),random());

        assert vector.getX() != 0;

        vector.resetX();

        assert vector.getX() == 0;
    }

    @Test
    public void resetY() throws Exception {
         Vector2D vector = new Vector2D(random(),random());

        assert vector.getY() != 0;

        vector.resetY();

        assert vector.getY() == 0;
    }

    @Test
    public void cloneTest() throws Exception {

        float x = random();
        float y = random();
        Vector2D vector1 = new Vector2D(x, y);
        Vector2D vector2 = new Vector2D(x, y);

        assert vector1.equals(vector2);
        assert vector2.equals(vector1);

        

    }

    private float random(){
        return (float)Math.random();
    }

}