package com.saints.test;

import com.mygdx.game.LibGDXGraphics;
import com.saints.gamecode.gameobjects.characters.Character;
import com.saints.gamecode.gameobjects.characters.SmurfCharacter;
import com.saints.gamecode.interfaces.IKeyInput;
import org.junit.Test;
import com.saints.gamecode.scenes.Arena;

import static org.junit.Assert.*;

public class ArenaTest {

    private Arena arena = new Arena(new InputSimulator(), new GraphicsSim());

    @Test
    public void setCharacters() throws Exception {
        Character player1 = new SmurfCharacter(true);
        Character player2 = new SmurfCharacter(false);
        arena.setCharacters(player1, player2);

        assert arena.getGameObjects().contains(player1);
        assert arena.getGameObjects().contains(player2);
    }

    @Test
    public void addItem() throws Exception {
        int nmbrOfObject = arena.getGameObjects().size();
        arena.addItem();
        assert nmbrOfObject + 1 == arena.getGameObjects().size();
    }
}