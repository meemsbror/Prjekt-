package com.saints.gamecode;

import Entities.gameobjects.characters.Character;
import Entities.gameobjects.characters.SmurfCharacter;
import org.junit.Test;
import com.saints.gamecode.controllers.scenes.Arena;

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