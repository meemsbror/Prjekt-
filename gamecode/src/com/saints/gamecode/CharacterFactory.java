package com.saints.gamecode;

import com.saints.gamecode.gameobjects.characters.*;
import com.saints.gamecode.gameobjects.characters.Character;

public class CharacterFactory {

    public static Character createCharacter(String name){
        switch (name){
            case "Smurf" :
                return new SmurfCharacter(0,0);
            default:
                return new SmurfCharacter(0,0);
        }
    }
}
