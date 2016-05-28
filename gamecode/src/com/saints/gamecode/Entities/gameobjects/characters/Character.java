package com.saints.gamecode.Entities.gameobjects.characters;

import com.saints.gamecode.utils.AnimationObject;
import com.saints.gamecode.Entities.HealthBar;
import com.saints.gamecode.utils.State;
import com.saints.gamecode.utils.Vector2D;
import com.saints.gamecode.Entities.gameobjects.GameObject;

public abstract class Character extends GameObject {

    //The direction of the object
    private boolean facingRight;

    //If the player is moving
    private boolean isMoving;

    //Movementspeed
    private float moveSpeed = 100;

    //Boolean if the character is powered up
    boolean isPowered = false;

    //player one or 2
    boolean p1;

    //checks if the character has doubble jumped
    private boolean doubleJumped = true;

    //A timer for how often you can jump, nessesary to have to be able to doubble jump :(
    private float jumpTimer;

    public void setAttackPowerUpTime(float attackPowerUpTime) {
        this.attackPowerUpTime = attackPowerUpTime;
    }

    public float getAttackPowerUpTime() {

        return attackPowerUpTime;
    }

    //The time of when the attack power up ends
    private float attackPowerUpTime;

    //State
    private State state;


    public boolean isP1() {
        return p1;
    }

    public Character(int width, int height, AnimationObject animationObject,float moveSpeed, boolean p1){
        super(width,height,animationObject);

        this.moveSpeed = moveSpeed;
        this.p1 = p1;
        state = State.STALL;
    }

    //Sets image
    public State getState() {
        return state;
    }

    public float getMoveSpeed(){
        return moveSpeed;
    }

    public boolean isMoving(){
        return isMoving;
    }
    public boolean isFacingRight() {
        return facingRight;
    }

    public void setMoving(Boolean isMoving){
        this.isMoving = isMoving;
    }

    public void moveRight(){
        isMoving = true;
        facingRight = true;
    }

    public void moveLeft(){
        isMoving = true;
        facingRight = false;
    }
    public void swapHp(){
        HealthBar.getInstance().hpSwitch();
    }


    public void setState(State image) {
        this.state = image;
    }

    public boolean isPowered() {
        return isPowered;
    }


    //Abstract methods

    //Returns the initial jumpSpeed
    public abstract Vector2D getJumpSpeed();

    //Returns current hitpoints
    public abstract int getHitPoints();

    public abstract boolean attack (GameObject object);

    public abstract int getDamage();

    public abstract void jump();

    public abstract GameObject getStraightAttack();

    public abstract float getAttackCD();
    public abstract void setAttackCD(float time);

    public abstract float getAttackSpeed();

    //Powerup functions (increase damage, speed or whatever we come up with :)
    public abstract void powerUp(boolean poweredUp);

    public boolean isDoubleJumped() {
        return doubleJumped;
    }

    public void setDoubleJumped(boolean doubleJumped) {
        this.doubleJumped = doubleJumped;
    }

    public float getJumpTimer() {
        return jumpTimer;
    }

    public void setJumpTimer(float jumpTimer) {
        this.jumpTimer = jumpTimer;
    }
}
