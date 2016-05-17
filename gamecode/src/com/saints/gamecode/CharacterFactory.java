package com.saints.gamecode;

import com.saints.gamecode.gameobjects.characters.*;
import com.saints.gamecode.gameobjects.characters.Character;

public class CharacterFactory {

    public static Character createCharacter(String name){
       /*switch (name){
            case "Smurf" :
                return new SmurfCharacter(200,50);
            default:
                return new SmurfCharacter(100,0);
                */
        if (name == "Smurf") {return new SmurfCharacter(200,50);}
        else {return new SmurfCharacter(100,50);}
    }

    //Returns an array with the name of all available characters
    public static String [] getCharacters(){
        return new String [] {"smurf"};
    }
}
