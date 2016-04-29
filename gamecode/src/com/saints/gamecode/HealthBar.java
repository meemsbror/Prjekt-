package com.saints.gamecode;


//A HealthBar for representing the current state for BOTH players
public final class HealthBar {


    private static final HealthBar INSTANCE = new HealthBar();

    private HealthBar() {}

    public static HealthBar getInstance() {
        return INSTANCE;

    }


    // arbitrary 100% for now. These values are set in CharacterController
    private int currentMax = 100;
    // HP-bar divider variable: 40 is a dummy value for now so we can test if setter work
    private int divider = 40;


    // Getters and Setters for currentMax variable.
    // Method for setting the current HP bar's max
    // TODO: make private and access only through change methods?
    public void setMaxHealth(int x){
        this.currentMax = x;
    }

    // returns current game's Healthbar
    public int getMaxHealth(){
        return currentMax;
    }

    //Getters & setters for divider variable
    //TODO: make private and access only through change methods?
    public void setDivider(int x){
        this.divider = x;
    }
    public int getDivider(){
        return divider;
    }


    // TODO: make connection for whenever a Character is hit, this check will be carried out
    // boolean check for if either player has run out of HP
    public boolean isOver(){
        if (divider <= 0 || divider >= currentMax){
            return true;
        }else {
            return false;
        }
    }

    // method for HP-bar decay or pro-longing, depending on what happens in game
    // if we want to strip 1 hp from both, send in -1.
    // only to be called if we require equal change: no change on divider.
    public void changeGameLength(int hpChange){
        setMaxHealth(getMaxHealth() + (2 * hpChange));
    }

    // TODO: Take a look at the sudden death... We need to talk about how large he decrements are...
    // method called for if player 1 has less than x (timeChange) HP
    public void p1SuddenDeath(int hpChange){
        setDivider(1);
        changeGameLength(hpChange);
    }
    // method called for if player 2 has less than x (timeChange) HP
    public void p2SuddenDeath(int hpChange){
        setDivider(currentMax-(1+2*hpChange));
        changeGameLength(hpChange);
    }

    // @param: The contract of this update is that we send in positive or negative damage
    public void updateDivider(int dmg){
        setDivider(getDivider() + dmg);
    }

    @Override
    public String toString(){
        return getClass().getName() +
                " class, current info:\nDivider at:" + getDivider() +
                "\nCurrent Maximum: " + getMaxHealth() +
                "\nPlayer 1 status: " + getDivider() +
                "\nPlayer 2 status: " + (getMaxHealth()-getDivider());

    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        HealthBar HPBar = (HealthBar)o;
        if (this == o){
            return true;
        }

        if (currentMax != HPBar.currentMax){
            return false;
        }
        if (divider != HPBar.divider){
            return false;
        }
        return (currentMax == getInstance().getMaxHealth() && divider == getInstance().getDivider());
    }


}
