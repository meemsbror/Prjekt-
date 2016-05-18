package com.saints.gamecode.gameobjects.characters;

import com.saints.gamecode.AnimationObject;
import com.saints.gamecode.Position;
import com.saints.gamecode.State;
import com.saints.gamecode.Vector2D;
import com.saints.gamecode.gameobjects.GameObject;
import com.saints.gamecode.gameobjects.characters.attacks.StraightAttack;
import com.saints.gamecode.gameobjects.items.AttackPower;
import com.saints.gamecode.gameobjects.items.Item;

public abstract class Character extends GameObject {

    //The direction of the object
    private boolean facingRight;

    //If the player is moving
    private boolean isMoving;

    //Movementspeed
    private float moveSpeed = 100;

    //Boolean if the character is powered up
    boolean isPowered = false;

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


    public Character(int width, int height, AnimationObject animationObject){
        super(width,height,animationObject);
        state = State.STALL;
    }
    /*
    public abstract boolean attack(GameObject gameObject);
    */

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


    public void setState(State image) {
        this.state = image;
    }

    public boolean isPowered() {
        return isPowered;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Character character = (Character) o;


        if (facingRight != character.facingRight) return false;

      //  return hitPoints == character.hitPoints;

        //TODO: remove hitPoints? and fix dummy return state just below this line;
        return true;
       // return hitPoints == character.hitPoints;

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

    //Powerup functions (increase damage, speed or whatever we come up with :)
    public abstract void powerUp(boolean poweredUp);


}
