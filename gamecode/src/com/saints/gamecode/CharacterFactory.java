package com.saints.gamecode;

import com.saints.gamecode.characters.Character;
import com.saints.gamecode.characters.SmurfCharacter;

public class CharacterFactory {

    public static Character createCharacter(){
        return new SmurfCharacter(10,10,5,5);
    }
}
