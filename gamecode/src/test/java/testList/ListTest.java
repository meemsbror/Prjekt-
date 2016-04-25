package test.java.testList;


import static org.junit.Assert.assertTrue;

import com.saints.gamecode.CharacterController;
import com.saints.gamecode.CharacterFactory;
import com.saints.gamecode.dependencies.KeyInput;
import com.saints.gamecode.gameobjects.characters.Character;
import com.saints.gamecode.interfaces.IKeyInput;
import org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by admin on 2016-04-19.
 */
public class ListTest {
    @Test
    public void testMove(){
        Character char1 = CharacterFactory.createCharacter();
        Character char2 = CharacterFactory.createCharacter();
        //new CharacterController(char1, char2, keyInput);
    }
}