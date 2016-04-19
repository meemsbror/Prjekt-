package com.saints.gamecode;


//A HealthBar for representing the current state for BOTH players
public final class HealthBar {


    private static final HealthBar INSTANCE = new HealthBar();

    private HealthBar() {}

    public static HealthBar getInstance() {
        return INSTANCE;
    }


    // TODO: set current max to player 1 + player 2
    private int currentMax = 100;
    // TODO: set divider to currentMax - Player1's HP
    private int divider;


    // Method for setting the current HP bar's max
    public void setMaxHealth(int x){
        this.currentMax += x;
    }

    // returns current game's Healthbar
    public int getMaxHealth(){
        return currentMax;
    }

    /*
    // TODO find p1 & p2
    // boolean check for if either player has run out of HP
    public boolean isOver(){
        if (Player1 || Player2){
            return true;
        }
    }
    */

}
