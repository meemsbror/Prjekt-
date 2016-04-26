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
        healthBar.setMaxHealth(35);
        int maxHealth = healthBar.getMaxHealth();
        assertTrue(maxHealth == 35);
        healthBar.setMaxHealth(70);
        maxHealth = healthBar.getMaxHealth();
        assertTrue(maxHealth == 70);
        healthBar.setMaxHealth(50);
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
        healthBar.p1SuddenDeath(1);

    }
}
