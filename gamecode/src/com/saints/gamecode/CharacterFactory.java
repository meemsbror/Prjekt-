package com.saints.gamecode;

import com.saints.gamecode.gameobjects.characters.*;
import com.saints.gamecode.gameobjects.characters.Character;

public class CharacterFactory {

    public static Character createCharacter(String name){
       switch (name){
            case "Smurf" :
                return new SmurfCharacter(200,50);
            default:
                return new SmurfCharacter(100,0);
                }
    }

    //Returns an array with the name of all available characters
    public String [] getCharacters(){
        return new String [] {"smurf"};
    }
}
