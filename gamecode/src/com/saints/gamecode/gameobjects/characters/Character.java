package com.saints.gamecode.gameobjects.characters;

import com.saints.gamecode.State;
import com.saints.gamecode.gameobjects.GameObject;

public abstract class Character extends GameObject {

    //The direction of the object
    boolean facingRight;

    //State
    private State state;

    // TODO: Remove?
    private int hitPoints = 50;

    public Character(int x,int y, int width, int height){
        super(x,y,width,height);
        state = State.STALL;
    }

    public abstract boolean attack(GameObject gameObject);
    public abstract int getDamage();
    public abstract String getSpriteSheetPath();
    //Sets image
    public State getState() {
        return state;
    }

    public void setState(State image) {
        this.state = image;
    }

    // TODO: Hitpoints moved to subtypes of characters, make abstract or let HealthBar carry this check out?

    public void takeDamage(int damage){
        hitPoints = hitPoints - damage;
        if(hitPoints < 0){
            //wincondition!
        }
    }
    public abstract int getHitPoints();
}
