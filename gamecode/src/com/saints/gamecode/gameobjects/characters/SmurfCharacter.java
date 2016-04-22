package com.saints.gamecode.gameobjects.characters;

import com.saints.gamecode.State;
import com.saints.gamecode.gameobjects.GameObject;
import com.saints.gamecode.gameobjects.characters.attacks.StraightAttack;

public class SmurfCharacter extends Character {


    // Unique HP for every Character
    private int hitPoints = 50;

    //Straight attack is the attack going straight to either side of the character.
    StraightAttack straightRightAttack;
    StraightAttack straightLeftAttack;

    int damage = 10;

    public SmurfCharacter(int x, int y){
        //SmurfCharacter is always 128x128!
        //TODO Anpassa höjden och bredden till spriten.
        super(x,y,128,128);

        straightRightAttack = new StraightAttack(x,y,50,50);
        straightLeftAttack = new StraightAttack(x,y,-50,50);
        setImage(State.STALL);
    }
    @Override
    public boolean attack(GameObject gameObject){
        if(straightRightAttack.collide(gameObject)) {
            return true;
        }
        return false;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getSpriteSheetPath() {
        return "pictures/smurf1.png";
    }

    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public void move(int dx, int dy){
        super.move(dx, dy);
        straightRightAttack.move(dx, dy);
    }

}
