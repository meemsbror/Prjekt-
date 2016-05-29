package com.saints.gamecode.Entities.gameobjects;

import com.saints.gamecode.Entities.HealthBar;
import com.saints.gamecode.utils.Physics;
import com.saints.gamecode.Entities.gameobjects.characters.Character;
import com.saints.gamecode.Entities.gameobjects.characters.SmurfCharacter;
import com.saints.gamecode.Entities.gameobjects.characters.StickCharacter;
import com.saints.gamecode.utils.Position;
import com.saints.gamecode.utils.State;
import org.junit.Test;

public class CharacterTest {
    private Physics physics = Physics.getInstance();

    @Test
    public void testAttack(){
        Character player1 = new SmurfCharacter(true);
        Character player2 = new SmurfCharacter(false);
        player1.setPosition(0,0);
        player2.setPosition(player1.getPos().getX() + player1.getWidth(),0);
        player1.move(1,0);
        player2.move(-1,0);

        assert(player1.attack(player2) || player1.getState() == State.PUNCH);
    }

    public void testMove(){
        Character player = new SmurfCharacter(true);
        Position pos = new Position(0,0);
        player.setPosition(pos);
        player.move(1,0);
        assert(player.getPos().getX() < pos.getX() || player.getState() == State.WALK);
        player.move(-2,0);
        assert(player.getPos().getX() > pos.getX() || player.getState() == State.WALK);
    }
    public void testJump(){
        Character player = new SmurfCharacter(true);
        Position pos = new Position(0,0);
        player.setPosition(pos);
        player.jump();
        assert(player.getPos().getY() > pos.getY() || player.getState() == State.JUMP);
    }
}
