package com.saints.gamecode;


//A HealthBar for representing the current state for BOTH players
public final class HealthBar {


    private static final HealthBar INSTANCE = new HealthBar();

    private HealthBar() {}

    public static HealthBar getInstance() {
        return INSTANCE;

    }


    // TODO: set current max to player 1 + player 2, this allows for characters to have different starting HP
    // arbitrary 100% for now.
    private int currentMax = 100;
    // TODO: set divider to currentMax - Player1's HP
    //
    // HP-bar divider variable
    // 40 is a dummy value for now so we can test if setter work
    private int divider = 40;


    // Getters and Setters for currentMax variable.
    // Method for setting the current HP bar's max
    // to be called when we
    public void setMaxHealth(int x){
        this.currentMax += x;
    }

    // returns current game's Healthbar
    public int getMaxHealth(){
        return currentMax;
    }

    //Getters & setters for divider variable
    //TODO: set the divider to the difference between currentMax & p1 or p2 & currentMax
    public void setDivider(){
        this.divider = currentMax - 50; // - Player1.getHP();
    }
    public int getDivider(){
        return divider;
    }

    // TODO: check for individual Character health,
    // TODO: make connection for whenever a Character is hit, this check will be carried out
    // boolean check for if either player has run out of HP
    public boolean isOver(){
        if (divider <= 0 || divider > currentMax){
            return true;
        }else {
            return false;
        }
    }


}
