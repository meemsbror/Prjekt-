package test.java.testList;

import com.saints.gamecode.HealthBar;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

// Class for testing HealthBar.java
public class HealthTest {

    @Test
    public void getterTest(){
        // basic values set in Healthbar class, divider to 40 and maxHealth to 100 for testing.
        HealthBar healthBar = HealthBar.getInstance();

        // test for divider
        int currentDivider;
        currentDivider = healthBar.getDivider();
        assertTrue(currentDivider == 40);

        // test for max health
        int maxHealth;
        maxHealth = healthBar.getMaxHealth();
        assertTrue(maxHealth == 100);
    }

    @Test
    public void setterTest(){
        // basic set values input
        HealthBar healthBar = HealthBar.getInstance();

        // test for setting divider
        healthBar.setDivider(80);
        int currentDivider = healthBar.getDivider();
        assertTrue(currentDivider == 80);
        healthBar.setDivider(30);
        currentDivider = healthBar.getDivider();
        assertTrue(currentDivider == 30);
        healthBar.setDivider(45);
        currentDivider = healthBar.getDivider();
        assertTrue(currentDivider == 45);

        //test for setting max health
        healthBar.setMax(35);
        int maxHealth = healthBar.getMaxHealth();
        assertTrue(maxHealth == 35);
        healthBar.setMax(70);
        maxHealth = healthBar.getMaxHealth();
        assertTrue(maxHealth == 70);
        healthBar.setMax(50);
        maxHealth = healthBar.getMaxHealth();
        assertTrue(maxHealth == 50);
    }

    @Test
    public void takeDamageTest(){
        // player 1 deal dmg
        HealthBar healthBar = HealthBar.getInstance();
        int currentDivider;
        currentDivider = healthBar.getDivider();
        healthBar.updateDivider(5);
        assertTrue(currentDivider +5 == healthBar.getDivider());

        // player 2 deal dmg
        healthBar.updateDivider(-10);
        assertTrue(currentDivider - 10 == healthBar.getDivider());
    }

    @Test
    public void changeGameLengthTest(){
        HealthBar healthBar = HealthBar.getInstance();
        int currentMaxHealth = healthBar.getMaxHealth(); //100

        // reduce both sides max health by 1
        healthBar.changeGameLength(-1); // should become 98
        assertTrue(currentMaxHealth - 2 == healthBar.getMaxHealth());

        // increase both sides max health by 5
        healthBar.changeGameLength(5); // should become 108
        assetTrue(currentMaxHealth + 10 == healthBar.getMaxHealth());
    }

    // TODO: incomplete
    @Test
    public void suddenDeathTest(){
        HealthBar healthBar = HealthBar.getInstance();
        int currentDivider = healthBar.getDivider(); //40
        int currentMax = healthBar.getMaxHealth(); //100

        // check for player 1 sudden death
        healthBar.p1SuddenDeath(-1); // set player 1 hp to 1 & reduce maxHP by 1 for each player
        assertTrue(currentDivider == 1 && currentMax == 98);

        // check for player 2 sudden death
        // note: current maxHP = 98
        healthBar.p2SuddenDeath(-1); // set player 2 hp to max -1 + (2*time change)
        assertTrue(currentDivider == 95 && currentMax == 96);

    }

    // TODO: some more tests
    @Test
    public void isOverTest(){
        HealthBar healthBar = HealthBar.getInstance();
        int currentDivider = healthBar.getDivider(); // 40
        int currentMax = healthBar.getMaxHealth(); // 100

        // game shouldn't be over yet.
        assertTrue(!healthBar.isOver());

        // should end game, return true.
        healthBar.setDivider(0);
        assertTrue(healthBar.isOver());

        // should return false
        healthBar.setDivider(98);
        assertTrue(!healthBar.isOver());

        // setting healthBar past divider (should never happen in game)
        healthBar.setMax(-10); // current divider = 98 and maxhealth  80 should return true
        assertTrue(healthBar.isOver());

    }
}
