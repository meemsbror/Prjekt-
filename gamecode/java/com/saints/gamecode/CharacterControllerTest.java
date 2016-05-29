package com.saints.gamecode;

import com.saints.gamecode.Entities.gameobjects.characters.Character;
import com.saints.gamecode.Entities.gameobjects.characters.CharacterFactory;
import com.saints.gamecode.utils.Direction;
import com.saints.gamecode.utils.Position;
import com.saints.gamecode.controllers.CharacterController;
import com.saints.gamecode.interfaces.IEntity;
import com.saints.gamecode.interfaces.IGraphics;
import org.junit.Test;

import java.util.ArrayList;


public class CharacterControllerTest {

    @Test
    public void moveMentTest(){

        InputSimulator input = new InputSimulator();
        IGraphics graphics = new GraphicsSim();

        CharacterController charcont = new CharacterController(new ArrayList<IEntity>(), input, new ArrayList<>(), graphics);

        Character p1 = CharacterFactory.createCharacter("Smurf",true);
        Character p2 = CharacterFactory.createCharacter("Lucky",false);

        charcont.setCharacters(p1,p2);

        Position pos1 = p1.getPosition();
        Position pos2 = p2.getPosition();



        input.setCurrentKey(Direction.P1JUMP);
        charcont.update(100);
        assert p1.isAirborne();
        assert !p1.getPos().equals(pos1);

        input.setCurrentKey(Direction.P2JUMP);
        charcont.update(100);
        assert p2.isAirborne();
        assert !p2.getPos().equals(pos2);
    }

}