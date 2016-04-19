package com.saints.gamecode.gameobjects.characters;

import com.saints.gamecode.gameobjects.GameObject;

public abstract class Character extends GameObject {

    //The direction of the object
    boolean facingRight;

    // HP set to 50 at start to represent the 'health-divder'
    private int hitPoints = 50;

    public Character(int x,int y, int width, int height){
        super(x,y,width,height);
    }

    public abstract boolean attack(GameObject gameObject);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Character character = (Character) o;

        if (facingRight != character.facingRight) return false;
        return hitPoints == character.hitPoints;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (facingRight ? 1 : 0);
        result = 31 * result + hitPoints;
        return result;
    }
}
