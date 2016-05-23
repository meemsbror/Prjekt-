package com.saints.gamecode;


import com.badlogic.gdx.Graphics;
import com.saints.gamecode.gameobjects.characters.Character;
import com.saints.gamecode.interfaces.IEntity;
import javafx.geometry.Pos;

//A HealthBar for representing the current state for BOTH players
public final class HealthBar implements IEntity{


    private static final HealthBar INSTANCE = new HealthBar();

    private HealthBar() {}

    public static HealthBar getInstance() {
        return INSTANCE;

    }


    // where Healthbar will be drawn
    private Position position = new Position(50, 50);

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
	private int width;

    private boolean gameOver = false;
    private String winner = "none";


	private AnimationObject animationObject1 = new AnimationObject("assets/pictures/HPBarBase.png", 1,1,1);
	private AnimationObject animationObject2 = new AnimationObject("assets/pictures/HPBarTop.png", 1,1,1);


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
	   // whenever the divider is changed, update width of divider. This factorizes a lot of code
        setWidth(toPercent(getDivider(),getP1Limit(),getP2Limit()));
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
        int dividerNow = getDivider();
        if (dividerNow <= getP1Limit() || dividerNow >= getP2Limit()){
            setIsGameOver(true);
            return getIsGameOver();
        }else {
            setIsGameOver(false); // probably redundant
            return getIsGameOver();
        }
    }

    // method for HP-bar decay or pro-longing, depending on what happens in game
    // if we want to strip 1 hp from both, send in -1.
    // only to be called if we require equal change: no change on divider.
    public void changeGameLength(int delta){
        // should never happen in game
        if (delta == 0){
            return;
        }
	    // calls for suddenDeath if P2 is losing
	    if ((getP1Limit() - delta) >= getDivider()){
            p2SuddenDeath(delta);
        }
        // calls for suddenDeath if P1 is losing
        if (getP2Limit() + delta <= getDivider()){
            p1SuddenDeath(delta);
	    }

        // set max time if HP Change exceeds maximum.
        if((getP1Limit() + delta <= getStartingMin())
                && (getP2Limit() - delta >= getStartingMax())){
            setP2Limit(getStartingMax());
            setP1Limit(getStartingMin());
        }
        else{
            setP2Limit(getP2Limit() + delta);
            setP1Limit(getP1Limit() - delta);
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
        setDivider(getP2Limit() + (hpChange-1));
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

	// approximates what width the healthbar should have, hence int values
	public int toPercent(int divider, int minLimit, int maxLimit){

		int rangeTmp = maxLimit - minLimit;
		int divTmp = (divider - minLimit) * 100;
		int percent = divTmp/rangeTmp;
		return percent;
	}

    @Override
    public String toString(){
        return getClass().getName() +
                " class, current info:" +
                "\nDivider at:" + getDivider() +
                "\nCurrent Maximum: " + getP2Limit() +
                "\nPlayer 1 status: " + (getDivider() - getP1Limit()) +
                "\nPlayer 2 status: " + (getP2Limit()- getDivider()) +
		        "\nWidth: " + getWidth();

    }

    @Override
    public Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            //Never invoked
        }
        return null;
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


    @Override
    public void setPosition(int x, int y) {
        this.position.setX(x);
        this.position.setY(y);
    }

    @Override
    public Position getPosition() {
        return position;
    }


    @Override
    public int getWidth() {
        return width;
    }
	public void setWidth(int width){
		this.width = width;
	}

    @Override
    public int getHeight() {
        return 127;
    }
    public AnimationObject getAnimationObject1(){
        return animationObject1;
    }
    public AnimationObject getAnimationObject2(){
        return animationObject2;
    }
}
