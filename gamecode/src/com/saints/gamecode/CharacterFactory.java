package com.saints.gamecode;

import com.saints.gamecode.gameobjects.characters.*;
import com.saints.gamecode.gameobjects.characters.Character;

public class CharacterFactory {

    public static Character createCharacter(String name){
        //Singelton-ish pattern to place players on different places?
        /*switch (name){
            case "Smurf" :
                return new SmurfCharacter(0,0);
            default:
                return new SmurfCharacter(0,0);
                */
        if (name == "Smurf") {return new SmurfCharacter(200,50);}
        else {return new SmurfCharacter(100,50);}
    }
}
