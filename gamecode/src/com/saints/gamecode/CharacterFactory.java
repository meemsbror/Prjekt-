package com.saints.gamecode;

import Entities.gameobjects.characters.*;
import Entities.gameobjects.characters.Character;

public class CharacterFactory {

    static String [] characters = {"Smurf"};

    public static Character createCharacter(String name, boolean p1){
        switch (name){
           case "Smurf" :
               characters[characters.length-1] = "Smurf";
               return new SmurfCharacter(p1);
           case "Lucky" :
               characters[characters.length-1] = "Lucky";
               return new StickCharacter(p1);
           default:
               return new SmurfCharacter(p1);
        }
    }

    //Returns an array with the name of all available characters
    public static String [] getCharacters(){
        return characters;
    }
}
