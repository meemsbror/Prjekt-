package com.saints.gamecode;


//A HealthBar for representing the current state for BOTH players
public final class HealthBar {


    private static final HealthBar INSTANCE = new HealthBar();

    private HealthBar() {}

    public static HealthBar getInstance() {
        return INSTANCE;

    }


    // TODO: set current max to player 1 + player 2 or just have it decreased until some player dies
    private int currentMax = 100;
    // TODO: set divider to currentMax - Player1's HP
    private int divider;


    // Getters and Setters for currentMax variable.
    // Method for setting the current HP bar's max
    public void setMaxHealth(int x){
        this.currentMax += x;
    }

    // returns current game's Healthbar
    public int getMaxHealth(){
        return currentMax;
    }

    //Getters & setters for divider variable
    public void setDivider(){
        this.divider = currentMax - Player1.getHP();
    }
    public int getDivider(){
        return divider;
    }

    // TODO: check for individual Character health
    // boolean check for if either player has run out of HP
    public boolean isOver(){
        if (divider <= 0 || divider > currentMax){
            return true;
        }else {
            return false;
        }
    }


}
