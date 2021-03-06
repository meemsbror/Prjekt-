package com.saints.gamecode;

import com.saints.gamecode.Entities.HealthBar;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

// Class for testing HealthBar.java
public class HealthTest {

    @Test
    public void getterTest(){
        // basic values set in Healthbar class, divider to 40 and maxHealth to 100 for testing.
        HealthBar healthBar = HealthBar.getInstance();
		healthBar.reset();

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

	    // test for width
	    int startingWidth = healthBar.getStartingWidth();
	    int width = healthBar.getWidth();
	    assertTrue(startingWidth == 0);
	    assertTrue(width == 0);
    }

    @Test
    public void setterTest(){
        // basic set values input
        HealthBar healthBar = HealthBar.getInstance();
		healthBar.reset();

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
        healthBar.setP2Limit(35); // will likely never be this value, but characters with different hp may be a thing
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

        //test for setWinner(String) // should either only be P1 P2 or "none"(standard)
        healthBar.setWinner("Player 1");
        String winner = healthBar.getWinner();
        assertTrue(winner.equals("Player 1"));
        healthBar.setWinner("Player 2");
        winner = healthBar.getWinner();
        assertTrue(winner.equals("Player 2"));

	    healthBar.setStartingWidth(80);
	    int startingWidth = healthBar.getStartingWidth();
	    assertTrue(startingWidth == 80);
		int width = healthBar.getWidth();
	    assertTrue(width == 80);
	    healthBar.setWidth(50);
	    width = healthBar.getWidth();
	    assertTrue(width == 50);

	    // Test added after toPercentTest
	    healthBar.reset();
    }

	@Test
	public void resetTest(){
		HealthBar healthBar = HealthBar.getInstance();
		healthBar.reset();
		healthBar.setStartingMax(78);
		healthBar.setDivider(75);
		healthBar.setWinner("Player 1");
		healthBar.setWidth(1000);
		healthBar.setP1Limit(20);
		healthBar.setP2Limit(76);
		healthBar.setIsGameOver(true);

		// proving starting-values have changed
		assertFalse((healthBar.getStartingMax() != 78));
		assertFalse((healthBar.getDivider() != 75));
		assertFalse(!(healthBar.getWinner().equals("Player 1")));
		assertFalse((healthBar.getWidth() != 1000));
		assertFalse(healthBar.getP1Limit() != 20);
		assertFalse(healthBar.getP2Limit() != 76);
		assertTrue(healthBar.getIsGameOver());


		// test begins
		healthBar.reset();

		int startingMax = healthBar.getStartingMax();
		assertTrue(startingMax == 100);
		int startingMin = healthBar.getStartingMin();
		assertTrue(startingMin == 0);
		int currentMax = healthBar.getP2Limit();
		assertTrue(currentMax == 100);
		int currentMin = healthBar.getP1Limit();
		assertTrue(currentMin == 0);
		int divider = healthBar.getDivider();
		assertTrue(divider == 40);
		int width = healthBar.getWidth();
		assertTrue(width == 0);
		boolean gameOver = healthBar.getIsGameOver();
		assertTrue(!gameOver);
		String winner = healthBar.getWinner();
		assertTrue(winner.equals("none"));
	}

    @Test
    public void dealDamageTest(){
        // player 1 deal dmg
        HealthBar healthBar = HealthBar.getInstance();
        int currentDivider = healthBar.getDivider(); // 40
        healthBar.dealDamage(5); // divider should == 45
        assertTrue((currentDivider + 5) == healthBar.getDivider());

        // player 2 deal dmg
	    currentDivider = healthBar.getDivider(); // 45
	    healthBar.dealDamage(-10); // 35
        assertTrue((currentDivider - 10) == healthBar.getDivider());
    }

    @Test
    public void changeGameLengthTest(){
        HealthBar healthBar = HealthBar.getInstance();
		healthBar.reset();
	    // these initial values translate exactly to the unset limits (default)
        int currentMinHealth = healthBar.getP1Limit(); //should be 0
	    int currentMaxHealth = healthBar.getP2Limit(); //should be 100
	    int maxLimit = healthBar.getStartingMax(); // should be 100
	    int minLimit = healthBar.getStartingMin(); // should be 0


	    assertTrue(currentMinHealth == 0);
	    assertTrue(currentMaxHealth == 100);
	    assertTrue(maxLimit == 100);
	    assertTrue(minLimit == 0);
        // reduce both sides max health by 1
        healthBar.changeGameLength(-1); // should become 1 && 99
	    // player 1 limit
	    currentMinHealth = healthBar.getP1Limit();
	    assertTrue(currentMinHealth == 1);
	    // player 2 limit
	    currentMaxHealth = healthBar.getP2Limit(); // should be 99
	    assertTrue(currentMaxHealth  == 99);


        // increase both sides max health by 5, should surpass set limits and should set to limits
        healthBar.changeGameLength(5);
	    currentMaxHealth = healthBar.getP2Limit();
	    currentMinHealth = healthBar.getP1Limit();
        assertTrue((currentMaxHealth = 100) == healthBar.getP2Limit());
        assertTrue((currentMinHealth = 0) == healthBar.getP1Limit());

	    healthBar.changeGameLength(0);
	    assertTrue(currentMaxHealth == healthBar.getP2Limit());
	    assertTrue(currentMinHealth == healthBar.getP1Limit());

	    // making sure these stayed the same.
	    assertTrue(maxLimit == 100);
	    assertTrue(minLimit == 0);
    }


    // TODO: incomplete
    @Test
    public void killTest(){
        HealthBar healthbar = HealthBar.getInstance();
	    int currentDivider;
	    int currentP1Limit = healthbar.getP1Limit(); // 0
	    int currentP2Limit = healthbar.getP2Limit(); // 100

	    healthbar.killP1();
	    currentDivider = healthbar.getDivider();
	    assertTrue(currentDivider == currentP1Limit);

	    healthbar.killP2();
	    currentDivider = healthbar.getDivider();
	    assertTrue(currentDivider == currentP2Limit);
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
	public void toPercentTest(){
		HealthBar healthBar = HealthBar.getInstance();
		healthBar.reset();
		int currentMax = healthBar.getP2Limit(); // 100
		int currentMin = healthBar.getP1Limit(); // 0
		int currentDivider = healthBar.getDivider(); // 40

		// only basic values

		//standard 40 expected
		assertTrue(healthBar.toPercent(currentDivider,currentMin,currentMax) == 40);
		healthBar.setDivider(60);
		currentDivider = healthBar.getDivider();
		assertTrue(healthBar.toPercent(currentDivider,currentMin,currentMax) == 60);

		// change game length
		healthBar.changeGameLength(-25);
		currentMin = healthBar.getP1Limit();
		currentMax = healthBar.getP2Limit();
		healthBar.setDivider(50);
		currentDivider = healthBar.getDivider();
		assertTrue(currentMin == 25);
		assertTrue(currentMax == 75);
		assertTrue(currentDivider == 50);
		assertTrue(healthBar.toPercent(currentDivider,currentMin,currentMax) == 50);


	}

    @Test
    public void suddenDeathTest(){
        HealthBar healthBar = HealthBar.getInstance();
		healthBar.reset();
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
		healthBar.reset();
		// initiation of everything, a clean HealthBar
		int currentMax = healthBar.getP2Limit(); // 100
		int currentMin = healthBar.getP1Limit(); // 0
		int maxLimit = healthBar.getStartingMax(); // 100
		int minLimit = healthBar.getStartingMin(); // 0
		int currentDivider = healthBar.getDivider(); // 40
		String winner = healthBar.getWinner(); // "none"
		boolean gameOver = healthBar.getIsGameOver(); // false;


		healthBar.setDivider(15);
		healthBar.changeGameLength(-20); // this should call for sudden death
		// divider should be set at 21 and limit at 20
		currentDivider = healthBar.getDivider();
		currentMin = healthBar.getP1Limit();
		currentMax = healthBar.getP2Limit();
		assertTrue(currentMin == 20);
		assertTrue(currentMax == 80);
		assertTrue(currentDivider  == 21);

		healthBar.dealDamage(-10); // damage surpassing limit, invoking conditional
		currentDivider = healthBar.getDivider();
		winner = healthBar.getWinner();
		gameOver = healthBar.getIsGameOver();
		assertTrue(currentDivider == 20);
		assertTrue(winner.equals("Player 2"));
		assertTrue(gameOver);
	}
}
