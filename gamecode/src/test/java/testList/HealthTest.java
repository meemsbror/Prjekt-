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
        maxHealth = healthBar.getP2Limit();
        assertTrue(maxHealth == 100);

        // test for min health, should be 0
        int minHealth = healthBar.getP1Limit();
        assertTrue(minHealth == 0);

        // test for starting max, should be 100
        int startMax = healthBar.getStartingMax();
        assertTrue(startMax == 100);

        // test for starting min, should be 0
        int startMin = healthBar.getStartingMin();
        assertTrue(minHealth == 0);

        // test for getting gameOver status
        boolean gameOver = healthBar.getIsGameOver();
        assertTrue(gameOver == false);

        // test for getting winner
        String winner = healthBar.getWinner();
        assertTrue(winner.equals("none")); // winner not set yet, this test found in setters


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

        //test for setting P2 max limit
        //healthBar.setP2limit(35); // will likely never be this value, but characters with different hp may be a thing
        int maxHealth = healthBar.getP2Limit();
        assertTrue(maxHealth == 35);

        healthBar.setP2Limit(70);
        maxHealth = healthBar.getP2Limit();
        assertTrue(maxHealth == 70);

        healthBar.setP2Limit(50);
        maxHealth = healthBar.getP2Limit();
        assertTrue(maxHealth == 50);

        // test for setting min limit
        healthBar.setP1Limit(20);
        int minHealth = healthBar.getP1Limit();
        assertTrue(minHealth == 20);

        healthBar.setP1Limit(40);
        minHealth = healthBar.getP1Limit();
        assertTrue(minHealth == 40);

	    healthBar.setP1Limit(35);
	    minHealth = healthBar.getP1Limit();
	    assertTrue(minHealth == 35);

        // test for setting starting max, there is no setter for min. Should always be 0.
        healthBar.setStartingMax(110);
        int startMax = healthBar.getStartingMax();
        assertTrue(startMax == 110);

        // test for setting gameOver(Boolean)
        healthBar.setIsGameOver(true);
        boolean gameOver = healthBar.getIsGameOver();
        assertTrue(gameOver == true);

        // test for setWinner(String) // should either only be P1 P2 or "none"(standard)
        healthBar.setWinner("Player 1");
        String winner = healthBar.getWinner();
        assertTrue(winner.equals("Player1"));
        healthBar.setWinner("Player 2");
        winner = healthBar.getWinner();
        assertTrue(winner.equals("Player 2"));


    }

    // joint tests later after we confirmed that these methods work.

    @Test
    public void dealDamageTest(){
        // player 1 deal dmg
        HealthBar healthBar = HealthBar.getInstance();
        int currentDivider = healthBar.getDivider(); // 40
        healthBar.dealDamage(5); // divider should == 45
        assertTrue(currentDivider + 5 == healthBar.getDivider());

        // player 2 deal dmg
        healthBar.dealDamage(-10); // 35
        assertTrue(currentDivider - 10 == healthBar.getDivider());
    }

    @Test
    public void changeGameLengthTest(){
        HealthBar healthBar = HealthBar.getInstance();
	    // these initial values translate exactly to the unset limits (default)
        int currentMinHealth = healthBar.getP1Limit(); //should be 0
	    int currentMaxHealth = healthBar.getP2Limit(); //should be 100
	    int maxLimit = healthBar.getStartingMax();
	    int minLimit = healthBar.getStartingMin();


        // reduce both sides max health by 1
        healthBar.changeGameLength(-1); // should become 1 && 99
	    // player 1 limit
	    assertTrue((currentMinHealth + 1) == healthBar.getP1Limit());
	    // player 2 limit
	    assertTrue((currentMaxHealth - 1)  == healthBar.getP2Limit());


        // increase both sides max health by 5, should surpass set limits and should set to limits
        healthBar.changeGameLength(5);
        assertTrue((currentMaxHealth = 100) == healthBar.getP2Limit());
        assertTrue((currentMinHealth = 0) == healthBar.getP1Limit());

	    // making sure these stay same.
	    assertTrue(maxLimit == 100);
	    assertTrue(minLimit == 0);
    }


    // TODO: incomplete
    @Test
    public void killTest(){
        HealthBar healthbar = HealthBar.getInstance();
    }
    @Test
    public void suddenDeathTest(){
        HealthBar healthBar = HealthBar.getInstance();
        int currentDivider = healthBar.getDivider(); //40
        int currentMax = healthBar.getP2Limit(); //100
        int currentMin = healthBar.getP1Limit();

        // check for player 1 sudden death
        healthBar.p1SuddenDeath(-1); // set player 1 hp to 1 & reduce maxHP by 1 for each player
        currentDivider = healthBar.getDivider(); // should be 2
        assertTrue(currentDivider == 2); // divider set to limit +1
        currentMax = healthBar.getP2Limit();
        assertTrue(currentMax == 99); // reduced by 1
        currentMin = healthBar.getP1Limit();
        assertTrue(currentMin == 1);

        // check for player 2 sudden death
        // note: current maxHP = 98 && min = 2
        currentDivider = healthBar.getDivider();
        assertTrue(currentDivider == 97);
        currentMax = healthBar.getP2Limit(); // should be 98
        assertTrue(currentMax == 98);
        currentMin = healthBar.getP1Limit(); // should be 2
        assertTrue(currentMin == 2);

    }

    // TODO: some more tests
   @Test
    public void isOverTest(){
        HealthBar healthBar = HealthBar.getInstance();
        int currentDivider = healthBar.getDivider(); // 40
        int currentMax = healthBar.getP2Limit(); // 100
        int currentMin = healthBar.getP1Limit(); // 0

	   healthBar.setP1Limit(30);
	   healthBar.setDivider(30);
	   currentMin = healthBar.getP1Limit();
	   currentDivider = healthBar.getDivider();
	   assertTrue(healthBar.isOver()); // should be true
	   healthBar.setDivider(60);
	   healthBar.setP2Limit(60);
	   assertTrue(healthBar.isOver()); // should be true
	   healthBar.setDivider(45);
	   assertTrue(!healthBar.isOver()); // should be false


    }

    @Test
    public void suddenDeathTest(){
        HealthBar healthBar = HealthBar.getInstance();
        int currentMax = healthBar.getP2Limit(); // 100
        int currentMin = healthBar.getP1Limit(); // 0
        int maxLimit = healthBar.getStartingMax(); // 100
        int minLimit = healthBar.getStartingMin(); // 0
        int currentDivider = healthBar.getDivider(); // 40

        // First Sudden Death. Limits should  equal +/- 1
        healthBar.p1SuddenDeath(-1); // divider should be 2 && currentmin 1
        currentMin = healthBar.getP1Limit();
        currentDivider = healthBar.getDivider();
        assertTrue(currentMin == 1);
        assertTrue(currentDivider == 2);

        // Second SD
        healthBar.p2SuddenDeath(-1); // divider should be 97 && currentMax 98
        currentMax = healthBar.getP2Limit();
        currentDivider = healthBar.getDivider();
        assertTrue(currentMax == 98);
        assertTrue(currentDivider == 97);

	    // making sure these stay same.
	    assertTrue(maxLimit == 100);
	    assertTrue(minLimit == 0);

    }

	// should be a quite complete test for everything going on.
	@Test
	public void conditionalTest(){
		HealthBar healthBar = HealthBar.getInstance();
		// initiation of everything, a clean HealthBar
		int currentMax = healthBar.getP2Limit(); // 100
		int currentMin = healthBar.getP1Limit(); // 0
		int maxLimit = healthBar.getStartingMax(); // 100
		int minLimit = healthBar.getStartingMin(); // 0
		int currentDivider = healthBar.getDivider(); // 40
		String winner = healthBar.getWinner(); // "none"
		boolean gameOver = healthBar.getIsGameOver(); // false;


	}
}
