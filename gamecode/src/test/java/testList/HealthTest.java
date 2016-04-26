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
        HealthBar healthBar = HealthBar.getInstance();
        int currentDivider;
        currentDivider = healthBar.getDivider();
        healthBar.updateDivider(5);
        assertTrue(currentDivider == healthBar.getDivider()+5);
    }
}
