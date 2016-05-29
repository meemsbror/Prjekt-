package com.saints.gamecode;

import com.saints.gamecode.HealthBar;
import com.saints.gamecode.Physics;
import com.saints.gamecode.gameobjects.characters.Character;
import com.saints.gamecode.gameobjects.characters.SmurfCharacter;
import com.saints.gamecode.gameobjects.characters.StickCharacter;
import com.saints.gamecode.scenes.Arena;
import org.junit.Test;

/**
 * Created by admin on 2016-05-25.
 */
public class CharacterTest {
    private Physics physics = Physics.getInstance();

    @Test
    public void testAttack(){
        InputSimulator inputSimulator = new InputSimulator();
        GraphicsSim graphicsSim = new GraphicsSim();
        Arena arena = new Arena(inputSimulator, graphicsSim);
        Character player1 = new SmurfCharacter(true);
        Character player2 = new SmurfCharacter(false);
        HealthBar healthBar = HealthBar.getInstance();
        int startHealth, currentHealth;
        startHealth = healthBar.getDivider();
        player1.setPosition(0,0);
        player2.setPosition(player1.getPos().getX() + player1.getWidth() + 10,0);
        player1.moveRight();
        player2.moveLeft();
        arena.update(0.1f);
        System.out.println(player1.getStraightAttack().toString());
        System.out.println(player2.getStraightAttack().toString());
        player1.attack(player2);

        currentHealth = healthBar.getDivider();

        assert(startHealth > currentHealth);
    }
}
