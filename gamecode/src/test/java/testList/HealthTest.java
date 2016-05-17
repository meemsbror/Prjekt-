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

        // test for divider, should be 40
        int currentDivider;
        currentDivider = healthBar.getDivider();
        assertTrue(currentDivider == 40);

        // test for max health, should be 100
        int maxHealth;
        maxHealth = healthBar.getMaxHealth();
        assertTrue(maxHealth == 100);

        // test for min health, should be 0
        int minHealth = healthBar.getMinHealth();
        assertTrue(minHealth == 0);
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
        healthBar.setMax(35); // will likely never be this value, but characters with different hp may be a thing
        int maxHealth = healthBar.getMaxHealth();
        assertTrue(maxHealth == 35);

        healthBar.setMax(70);
        maxHealth = healthBar.getMaxHealth();
        assertTrue(maxHealth == 70);

        healthBar.setMax(50);
        maxHealth = healthBar.getMaxHealth();
        assertTrue(maxHealth == 50);

        // test for setting min health
        healthBar.setMin(20);
        int minHealth = healthBar.getMinHealth();
        assertTrue(minHealth == 20);

        healthBar.setMin(40);
        minHealth = healthBar.getMinHealth();
        assertTrue(minHealth == 40);

	    healthBar.setMin(35);
	    minHealth = healthBar.getMinHealth();
	    assertTrue(minHealth == 35);

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
	    int currentMinHealth = healthBar.getMinHealth(); //0
	    int currentMaxHealth = healthBar.getMaxHealth(); //100

        // reduce both sides max health by 1
        healthBar.changeGameLength(-1); // should become 1 && 99
	    // player 1 limit
	    assertTrue((currentMinHealth + 1) == healthBar.getMinHealth());
	    // player 2 limit
	    assertTrue((currentMaxHealth - 1)  == healthBar.getMaxHealth());


	    // TODO MAKE SURE THAT -4 && 104 isn't possible?
        // increase both sides max health by 5
        healthBar.changeGameLength(5); // should become -4 && 104 (negative numbers should never happen tho??)
        assertTrue((currentMaxHealth + 5) == healthBar.getMaxHealth());
    }

    // TODO: incomplete
    @Test
    public void suddenDeathTest(){
        HealthBar healthBar = HealthBar.getInstance();
        int currentDivider = healthBar.getDivider(); //40
        int currentMax = healthBar.getMaxHealth(); //100

        // check for player 1 sudden death
        healthBar.p1SuddenDeath(-1); // set player 1 hp to 1 & reduce maxHP by 1 for each player
        assertTrue(currentDivider == 1 && currentMax == 99);

        // check for player 2 sudden death
        // note: current maxHP = 98
        healthBar.p2SuddenDeath(-1); // set player 2 hp to max -1 + (2*time change)
        assertTrue(currentDivider == 97 && currentMax == 98);

    }

    // TODO: some more tests
    @Test
    public void isOverTest(){
        HealthBar healthBar = HealthBar.getInstance();
        int currentDivider = healthBar.getDivider(); // 40
        int currentMax = healthBar.getMaxHealth(); // 100
        int currentMin = healthBar.getMinHealth(); // 0

        // game shouldn't be over yet.
        assertTrue(!healthBar.isOver());

        // should end game, return true.
        healthBar.setDivider(0);
        assertTrue(healthBar.isOver());

        // should return false
        healthBar.setDivider(98);
        assertTrue(!healthBar.isOver());

        // setting healthBar past divider (should never happen in game, this check must be done in the model
	    // and is not performed in Healthbar class - the healthbar does not know keep track of the characters.
	    // this test is merely a demonstration that the methods work as intended)
        healthBar.setMax(-10); // current divider = 98 and maxhealth  80 should return true
        assertTrue(healthBar.isOver());

    }
}
