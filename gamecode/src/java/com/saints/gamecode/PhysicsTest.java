package com.saints.gamecode;

import Entities.gameobjects.characters.SmurfCharacter;
import Entities.gameobjects.characters.StickCharacter;
import Entities.gameobjects.Platform;
import org.junit.Test;

public class PhysicsTest {

    private Physics physics = Physics.getInstance();

    @Test
    public void getInstance() throws Exception {

        assert physics == Physics.getInstance();

    }

    @Test
    public void isStandingOnPlatform() throws Exception {

        SmurfCharacter character = new SmurfCharacter(true);
        character.setPosition(-1,-1);

        Platform platform = new Platform(0,0,1,1);

        assert physics.isStandingOnPlatform(character,platform);

        character.setPosition(1,1);

        assert !physics.isStandingOnPlatform(character,platform);

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