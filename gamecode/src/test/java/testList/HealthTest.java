package test.java.testList;

import com.saints.gamecode.HealthBar;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by admin on 2016-04-26.
 */
public class HealthTest {
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
