package com.saints.gamecode;

import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterPanelTest {

    CharacterPanel characterPanel = new CharacterPanel("yolo", "swag");

    @Test
    public void setPlayer1Selected() throws Exception {

        characterPanel.setPlayer1Selected(true);
        assert characterPanel.isPlayer1Selected();
        characterPanel.setPlayer1Selected(false);
        assert !characterPanel.isPlayer1Selected();
    }

    @Test
    public void setPlayer2Selected() throws Exception {

        characterPanel.setPlayer2Selected(true);
        assert characterPanel.isPlayer2Selected();
        characterPanel.setPlayer2Selected(false);
        assert !characterPanel.isPlayer2Selected();

    }

    @Test
    public void setPosition() throws Exception {
        float x = (float)Math.random();
        float y = (float)Math.random();
        characterPanel.setPosition(x,y);

        Position pos = characterPanel.getPosition();

        assert x == pos.getX();
        assert y == pos.getY();
    }

}