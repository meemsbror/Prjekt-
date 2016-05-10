package com.saints.gamecode.gameobjects.characters;

import com.saints.gamecode.State;
import com.saints.gamecode.Vector2D;
import com.saints.gamecode.gameobjects.GameObject;

public abstract class Character extends GameObject {

    //The direction of the object
    private boolean facingRight;

    private boolean isMoving;

    private float moveSpeed = 100;

    //State
    private State state;

    // TODO: Remove?
    private int hitPoints = 50;

    public Character(int x,int y, int width, int height){
        super(x,y,width,height);
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

    public void setMoving(Boolean isMoving){
        this.isMoving = isMoving;
    }

    public void moveRight(){
        isMoving = true;
    }

    public void moveLeft(){
        isMoving = true;
    }

    public void setState(State image) {
        this.state = image;
    }

    // TODO: Hitpoints moved to subtypes of characters, make abstract or let HealthBar carry this check out?

    // TODO: Hitpoints moved to subtypes of characters, make abstract or let HealthBar carry this check out?

    public void takeDamage(int damage){
        hitPoints = hitPoints - damage;
        if(hitPoints < 0){
            //wincondition!
        }
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

    public abstract int getHitPoints();

    public abstract boolean attack (GameObject object);

    public abstract int getDamage();

    public abstract String getSpriteSheetPath();

    public abstract void jump();


}
