package com.saints.test;

import org.junit.Test;

import static org.junit.Assert.*;
import com.saints.gamecode.Position;

public class PositionTest {

    Position pos = new Position(0,0);

    @Test
    public void move() throws Exception {
        float x = random();
        float y = random();
        pos.setX(x);
        pos.setY(y);

        float dx = random();
        float dy = random();

        pos.move(dx, dy);

        assert pos.getX() == x + dx;
        assert pos.getY() == y + dy;

    }

    @Test
    public void cloneEqualsTest() throws Exception {
        float x = random();
        float y = random();

        Position clone = (Position)pos.clone();

        assert clone.equals(pos);
        assert pos.equals(clone);

        pos.move(random(),random());

        assert !pos.equals(clone);
        assert !clone.equals(pos);
        

    }

    private float random(){
        return (float)Math.random();
    }
}