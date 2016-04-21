package com.saints.gamecode.gameobjects.characters;

import com.saints.gamecode.gameobjects.GameObject;

public abstract class Character extends GameObject {

    //The direction of the object
    boolean facingRight;


    // TODO: Remove?
//    private int hitPoints = 50;

    public Character(int x,int y, int width, int height){
        super(x,y,width,height);
    }

    public abstract boolean attack(GameObject gameObject);
    public abstract int getDamage();

    // TODO: Hitpoints moved to subtypes of characters, make abstract or let HealthBar carry this check out?
    /*
    public void takeDamage(int damage){
        hitPoints = hitPoints - damage;
        if(hitPoints < 0){
            //wincondition!
        }
    }
    */

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

    public abstract int getHitPoints();

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (facingRight ? 1 : 0);
        // TODO: remove?
        //result = 31 * result + hitPoints;
        return result;
    }
}
