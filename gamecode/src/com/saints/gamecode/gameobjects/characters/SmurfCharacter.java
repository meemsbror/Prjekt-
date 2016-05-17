package com.saints.gamecode.gameobjects.characters;

import com.saints.gamecode.Physics;
import com.saints.gamecode.State;
import com.saints.gamecode.Vector2D;
import com.saints.gamecode.gameobjects.characters.attacks.StraightAttack;
import com.saints.gamecode.gameobjects.GameObject;


public class SmurfCharacter extends Character {

    private final Physics physics;

    //the initial speed that a character jumps with
    private final Vector2D jumpSpeed = new Vector2D(0, 100);

    //The time until next attack
    private float attackCD = 0;

    //Static value of how fast this character attacks
    private final float ATTACKSPEED = 1;

    // Unique HP for every Character
    private int hitPoints = 50;

    //Straight attack is the attack going straight to either side of the character.
    private StraightAttack straightAttack;


    //The ammount of damage this character has and the increasage in damage while powered up
    int DAMAGE = 10;


    public SmurfCharacter(int x, int y, boolean isPlayer1) {
        //SmurfCharacter is always 128x128!
        //TODO Anpassa höjden och bredden till spriten.
        super(x, y, 227, 386);
        straightAttack = new StraightAttack(x + getWidth()/2, y + getHeight()/2, 200, 70);
        setState(State.STALL);
        physics = Physics.getInstance();
        if (!isPlayer1){
            DAMAGE = -DAMAGE;
        }
    }

    @Override
    public boolean attack(GameObject gameObject){

        if(physics.hasCollided(this,gameObject)) {
            return true;
        }
        else{
            return false;
        }
    }

    /*
    public lvoid attack(GameObject gameObject){
        //TODO: move logic to controller
    }*/


    /*
    public lvoid attack(GameObject gameObject){
        //TODO: move logic to controller
    }*/


    @Override
    public int getDamage() {
        return (isPowered) ? DAMAGE : DAMAGE*2;
    }

    @Override
    public String getSpriteSheetPath() {
        return "assets/pictures/testSpriteSheetv2.png";
    }

    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public void move(float dx, float dy){
        super.move(dx, dy);
        straightAttack.setPosition(getPos().getX() + getWidth()/2,getPos().getY() + getHeight()/2 - 30);
    }

    public Vector2D getJumpSpeed(){
        return jumpSpeed;
    }

    public void jump(){

        changeDirection(jumpSpeed);
        setAirborne(true);
    }

    @Override
    public GameObject getStraightAttack() {
        return straightAttack;
    }

    @Override
    public float getAttackCD() {
        return attackCD;
    }

    @Override
    public void setAttackCD(float time) {
        this.attackCD = time + ATTACKSPEED;
    }


    @Override
    public void moveRight(){
        super.moveRight();
        setHorizontalSpeed(getMoveSpeed());
    }

    @Override
    public void moveLeft(){
        super.moveLeft();
        setHorizontalSpeed(-getMoveSpeed());
    }
    //Power up functions
    @Override
    public void powerUp(boolean poweredUp) {
        isPowered = poweredUp;
    }

}
