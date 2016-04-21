package com.saints.gamecode.gameobjects.characters;

import com.saints.gamecode.gameobjects.GameObject;
import com.saints.gamecode.gameobjects.characters.attacks.StraightAttack;

public class SmurfCharacter extends Character {

    //Straight attack is the attack going straight to either side of the character.
    StraightAttack straightRightAttack;
    StraightAttack straightLeftAttack;
    int damage = 10;

    public SmurfCharacter(int x, int y, int width, int height){
        super(x,y,width,height);
        straightRightAttack = new StraightAttack(x,y,50,50, "assets/pictures/fisted.png");
        straightLeftAttack = new StraightAttack(x,y,-50,50, "assets/pictures/fisted.png");
        setImgPath("assets/pictures/smurf1.png");
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
    public void move(int dx, int dy){
        super.move(dx, dy);
        straightRightAttack.move(dx, dy);
    }
}
