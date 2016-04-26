package test.java.testList;


import static org.junit.Assert.assertTrue;

import com.saints.gamecode.*;
import com.saints.gamecode.gameobjects.characters.Character;
import org.junit.Test;

/**
 * Created by admin on 2016-04-19.
 */
public class InputTest {

    @Test
    public void testMove(){
        Character char1 = CharacterFactory.createCharacter();
        Character char2 = CharacterFactory.createCharacter();
        InputSimulator inputSimulator = new InputSimulator();
        CharacterController characterController = new CharacterController(char1, char2, inputSimulator);
        Position startPos = new Position(0,0);

        //Walk every direction.
        startPos = char1.getPos();
        inputSimulator.setCurrentKey(Direction.P1LEFT);
        characterController.movePlayers();
        assertTrue(startPos.getX() > char1.getPos().getX() && char1.getState() == State.WALK);

        startPos = char1.getPos();
        inputSimulator.setCurrentKey(Direction.P1RIGHT);
        characterController.movePlayers();
        assertTrue(startPos.getX() < char1.getPos().getX() && char1.getState() == State.WALK);

        startPos = char1.getPos();
        inputSimulator.setCurrentKey(Direction.P1JUMP);
        characterController.movePlayers();
        assertTrue(startPos.getY() < char1.getPos().getY() && char1.getState() != State.JUMP);
    }
}