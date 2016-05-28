package com.saints.gamecode;

import com.saints.gamecode.Entities.gameobjects.characters.Character;
import com.saints.gamecode.Entities.gameobjects.characters.SmurfCharacter;
import com.saints.gamecode.Entities.gameobjects.characters.StickCharacter;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterFactoryTest {
    @Test
    public void createCharacter() throws Exception {

        Character character = CharacterFactory.createCharacter("Smurf",true);
        assert character instanceof SmurfCharacter;

        character = CharacterFactory.createCharacter("Lucky",false);
        assert character instanceof StickCharacter;

    }

}