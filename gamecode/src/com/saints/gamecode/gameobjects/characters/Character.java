package com.saints.gamecode.gameobjects.characters;

<<<<<<< HEAD
import com.saints.gamecode.State;
=======
>>>>>>> 6f6a1aef60329138f18e199af53a6b793b4e38b8
import com.saints.gamecode.Vector2D;
import com.saints.gamecode.gameobjects.GameObject;

public abstract class Character extends GameObject {

    //The direction of the object
    private boolean facingRight;

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

    //Returns the initial jumpSpeed
    public abstract Vector2D getJumpSpeed();
<<<<<<< HEAD
=======

    public abstract int getHitPoints();
>>>>>>> 6f6a1aef60329138f18e199af53a6b793b4e38b8

    public abstract int getHitPoints();
}
