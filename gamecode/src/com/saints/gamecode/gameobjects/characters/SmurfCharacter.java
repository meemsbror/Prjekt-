package com.saints.gamecode.gameobjects.characters;

import com.saints.gamecode.Vector2D;
import com.saints.gamecode.gameobjects.GameObject;
import com.saints.gamecode.gameobjects.characters.attacks.StraightAttack;

public class SmurfCharacter extends Character {


    //the initial speed that a character jumps with
    private Vector2D jumpSpeed;

    // Unique HP for every Character
    private int hitPoints = 50;
    //Straight attack is the attack going straight to either side of the character.
    StraightAttack straightRightAttack;
    StraightAttack straightLeftAttack;
    int damage = 10;

    public SmurfCharacter(int x, int y, int width, int height){
        super(x,y,width,height);
        jumpSpeed = new Vector2D(0,15);
        straightRightAttack = new StraightAttack(x,y,50,50);
        straightLeftAttack = new StraightAttack(x,y,-50,50);
        setImgPath("assets/pictures/smurf1.png");
    }

    /*
    public lvoid attack(GameObject gameObject){
        //TODO: move logic to controller
    }*/


    @Override
    public int getDamage() {
        return damage;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public void move(float dx, float dy){
        super.move(dx, dy);
        straightRightAttack.move(dx, dy);
    }

    public Vector2D getJumpSpeed(){
        return jumpSpeed;
    }

}
