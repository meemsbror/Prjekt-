package com.saints.gamecode;

import com.saints.gamecode.gameobjects.characters.*;
import com.saints.gamecode.gameobjects.characters.Character;

public class CharacterFactory {

    public static Character createCharacter(String name, boolean p1){
       switch (name){
            case "Smurf" :
                return new SmurfCharacter(p1);
            default:
                return new SmurfCharacter(p1);
       }
    }

    //Returns an array with the name of all available characters
    public static String [] getCharacters(){
        return new String [] {"Smurf"};
    }
}
