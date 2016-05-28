package com.saints.gamecode;

import com.saints.gamecode.Entities.gameobjects.characters.SmurfCharacter;
import com.saints.gamecode.Entities.gameobjects.characters.StickCharacter;
import org.junit.Test;

public class PhysicsTest {

    private Physics physics = Physics.getInstance();

    @Test
    public void getInstance() throws Exception {

        assert physics == Physics.getInstance();

    }

    @Test
    public void isStandingOnPlatform() throws Exception {
        //TODO: Write this. Ludvig should do it since he wrote the method.
    }

    @Test
    public void isInAir() throws Exception {
        //TODO: Write this. Ludvig should do it since he wrote the method.
    }

    @Test
    public void hasCollided() throws Exception {
        this.physics = Physics.getInstance();

        SmurfCharacter char1= new SmurfCharacter(true);
        StickCharacter char2= new StickCharacter(false);

        char1.setPosition(0,0);
        char2.setPosition(0,0);

        assert physics.hasCollided(char1,char2);
        assert physics.hasCollided(char2,char1);

        char2.move(char1.getWidth()+1,0);

        assert !physics.hasCollided(char1,char2);
        assert !physics.hasCollided(char2,char1);

        char2.setPosition(0,0);
        char2.move(0,char1.getHeight()+1);

        assert !physics.hasCollided(char1,char2);
        assert !physics.hasCollided(char2,char1);
    }
}