package com.saints.gamecode.gameobjects.characters;

import com.saints.gamecode.Physics;
import com.saints.gamecode.State;
import com.saints.gamecode.Vector2D;
import com.saints.gamecode.gameobjects.characters.attacks.StraightAttack;
import com.saints.gamecode.gameobjects.GameObject;


public class SmurfCharacter extends Character {

    private final Physics physics;

    //the initial speed that a character jumps with
    private Vector2D jumpSpeed = new Vector2D(0, 100);

    // Unique HP for every Character
    private int hitPoints = 50;

    //Straight attack is the attack going straight to either side of the character.
    private StraightAttack straightRightAttack;
    private StraightAttack straightLeftAttack;

    int damage = 10;

    public SmurfCharacter(int x, int y) {
        //SmurfCharacter is always 128x128!
        //TODO Anpassa höjden och bredden till spriten.
        super(x, y, 128, 128);
        straightRightAttack = new StraightAttack(x, y, 50, 50);
        straightLeftAttack = new StraightAttack(x, y, -50, 50);
        setState(State.STALL);
        physics = Physics.getInstance();
    }

    @Override
    public boolean attack(GameObject gameObject){

        if(physics.hasCollided(this,gameObject)) {
            return true;
        }
        else{
            return false;
        }
    }

    /*
    public lvoid attack(GameObject gameObject){
        //TODO: move logic to controller
    }*/


    /*
    public lvoid attack(GameObject gameObject){
        //TODO: move logic to controller
    }*/


    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getSpriteSheetPath() {
        return "assets/pictures/testGrid.png";
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

    public void jump(){

        changeDirection(jumpSpeed);
        setAirborne(true);
    }
}
