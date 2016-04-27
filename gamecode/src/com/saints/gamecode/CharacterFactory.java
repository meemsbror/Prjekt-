package com.saints.gamecode;

import com.saints.gamecode.gameobjects.characters.*;
import com.saints.gamecode.gameobjects.characters.Character;

public class CharacterFactory {

    public static Character createCharacter(){
        return new SmurfCharacter(10,10);
    }
}
