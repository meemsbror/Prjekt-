package com.saints.gamecode;

import com.saints.gamecode.characters.Character;
import com.saints.gamecode.characters.SmurfCharacter;

public class CharacterFactory {

    public Character createCharacter(){
        return new SmurfCharacter(10,10);
    }
}
