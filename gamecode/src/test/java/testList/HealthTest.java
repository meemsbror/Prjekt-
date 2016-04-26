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

        //test for setting max health
        healthBar.setMaxHealth(35);
        int maxHealth = healthBar.getMaxHealth();
        assertTrue(maxHealth == 35);
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
}
