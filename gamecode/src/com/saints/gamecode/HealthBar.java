package com.saints.gamecode;


//A HealthBar for representing the current state for BOTH players
public final class HealthBar {


    private static final HealthBar INSTANCE = new HealthBar();

    private HealthBar() {}

    public static HealthBar getInstance() {
        return INSTANCE;

    }


    // starting max (game length should not exceed this)
    private int startingMax = 100;

    // starting min, should always be 0
    private int startingMin = 0;

    // arbitrary 100% for now. These values are set in CharacterController
    private int currentMax = 100;
    // player 1's minimum HP
    private int currentMin = 0;
    // HP-bar divider variable: 40 is a dummy value for now so we can test if setter work
    private int divider = 40;
    // Is game still on?
    private boolean gameOver = false;
    private String winner = "none";


    // Getters and Setters for currentMax variable.
    // Method for setting the current HP bar's max
    public void setP2Limit(int maxLimit){
        this.currentMax = maxLimit;
    }

    // returns maximum state of healthbar
    public int getP2Limit(){
        return currentMax;
    }

    // Getters and Setters for currentMin variable
    // Method for setting currentMin state of healthbar
    public void setP1Limit(int minLimit){
        this.currentMin = minLimit;
    }

    // returns player 1's minimum state
    public int getP1Limit(){
        return currentMin;
    }
    //Getters & setters for divider variable
   public void setDivider(int x){
        this.divider = x;
   }
    public int getDivider(){
        return divider;
    }

    // Getter & setters for starting max && min (no setter for min, should always be 0)
    public void setStartingMax(int startingMax){
        this.startingMax = startingMax;
    }

    public int getStartingMax() {
        return startingMax;
    }
    public int getStartingMin(){
        return startingMin;
    }

    public void setIsGameOver(boolean isOver){
        this.gameOver = isOver;
    }
    //
    public boolean getIsGameOver(){
        return gameOver;
    }
    // boolean check for if either player has run out of HP
    public boolean isOver(){
        if (divider <= currentMin || divider >= currentMax){
            setIsGameOver(true);
            return gameOver;
        }else {
            setIsGameOver(false);
            return gameOver;
        }
    }

    // method for HP-bar decay or pro-longing, depending on what happens in game
    // if we want to strip 1 hp from both, send in -1.
    // only to be called if we require equal change: no change on divider.
    public void changeGameLength(int hpChange){
        // should never happen
        if (hpChange == 0){
            return;
        }
	    // calls for suddenDeath if P2 is losing
	    if ((getP1Limit() - hpChange) >= getP2Limit()){
            p2SuddenDeath(hpChange);
        }
        // calls for suddenDeath if P1 is losing
        if (getP2Limit() + hpChange <= getP1Limit()){
            p1SuddenDeath(hpChange);
	    }

        // set max time if HP Change exceeds maximum.
        if((getP1Limit() + hpChange <= getStartingMin())
                && (getP2Limit() - hpChange >= getStartingMax())){
            setP2Limit(startingMax);
            setP1Limit(startingMin);
        }
        else{
            setP2Limit(getP2Limit() + hpChange);
            setP1Limit(getP1Limit() - hpChange);
        }
    }

    // method called for if player 1 has less than x (timeChange) HP
	// this check is performed when called
   public void p1SuddenDeath(int hpChange){
        setDivider(currentMin-((hpChange-1)));
        changeGameLength(hpChange);
    }
    // method called for if player 2 has less than x (timeChange) HP
   public void p2SuddenDeath(int hpChange){
        setDivider(currentMax + (hpChange-1));
        changeGameLength(hpChange);
   }

    public void killP1(){
        setDivider(currentMin);
        setWinner("Player 2");
        isOver();
    }
    public void killP2(){
        setDivider(currentMax);
        setWinner("Player 1");
        isOver();
    }

    public void setWinner(String player){
        this.winner = player;
    }
    public String getWinner(){
        return winner;
    }
    // @param: The contract of this update is that we send in positive or negative damage
    // Player 1 deals +dmg and Player 2 -dmg.
    public void dealDamage(int dmg){
        if (getDivider() + dmg <= getP1Limit()){
            killP1();
        }
        if (getDivider() + dmg >= getP2Limit()){
            killP2();
        }
        else {
            setDivider(getDivider() + dmg);

        }
    }

    @Override
    public String toString(){
        return getClass().getName() +
                " class, current info:" +
                "\nDivider at:" + getDivider() +
                "\nCurrent Maximum: " + getP2Limit() +
                "\nPlayer 1 status: " + (getDivider() - getP1Limit()) +
                "\nPlayer 2 status: " + (getP2Limit()- getDivider());

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

        if (gameOver != HPBar.getIsGameOver()){
            return false;
        }
        if (currentMax != HPBar.currentMax){
            return false;
        }
        if (divider != HPBar.divider){
            return false;
        }
        if (currentMin != HPBar.currentMin){
            return false;
        }

        return (currentMax == getInstance().getP2Limit() &&
                currentMin == getInstance().getP1Limit() &&
                gameOver == getInstance().getIsGameOver() &&
                startingMax == getInstance().getStartingMax() &&
                startingMin == getInstance().getStartingMin() &&
                divider == getInstance().getDivider());
    }


}
