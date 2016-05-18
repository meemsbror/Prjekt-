package com.saints.gamecode.gameobjects.characters;

import com.saints.gamecode.*;
import com.saints.gamecode.gameobjects.characters.attacks.StraightAttack;
import com.saints.gamecode.gameobjects.GameObject;


public class SmurfCharacter extends Character {

    private final Physics physics;

    //the initial speed that a character jumps with
    private final Vector2D jumpSpeed = new Vector2D(0, 100);

    //The time until next attack
    private float attackCD = 0;

    //Static value of how fast this character attacks
    private final float ATTACKSPEED = 1;

    //Straight attack is the attack going straight to either side of the character.
    public StraightAttack straightAttack;

    // Unique HP for every Character
    private int hitPoints = 50;


    //The ammount of damage this character has and the increasage in damage while powered up
    int DAMAGE = 10;


    public SmurfCharacter(boolean isPlayer1) {
        //SmurfCharacter is always 128x128!
        //TODO Anpassa höjden och bredden till spriten.
        super(227, 386, new AnimationObject("assets/pictures/testSpriteSheetv2.png", 6, 4, 1f/6f));
        straightAttack = new StraightAttack(194, 117, new AnimationObject("assets/pictures/SmurfAttackSprite.png",6,1,1f/6f));
        setState(State.STALL);
        physics = Physics.getInstance();
        if (!isPlayer1){
            DAMAGE = -DAMAGE;
        }
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
    @Override
    public int getDamage() {
        return (isPowered) ? DAMAGE : DAMAGE*2;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public void move(float dx, float dy){
        super.move(dx, dy);
        straightAttack.setPosition(getPos().getX() + 110, getPos().getY() + 150);
    }

    public Vector2D getJumpSpeed(){
        return jumpSpeed;
    }

    public void jump(){

        changeDirection(jumpSpeed);
        straightAttack.changeDirection(jumpSpeed);
        setAirborne(true);
    }

    @Override
    public GameObject getStraightAttack() {
        return straightAttack;
    }

    @Override
    public float getAttackCD() {
        return attackCD;
    }

    @Override
    public void setAttackCD(float time) {
        this.attackCD = time + ATTACKSPEED;
    }


    @Override
    public void moveRight(){
        super.moveRight();
        setHorizontalSpeed(getMoveSpeed());
    }

    @Override
    public void moveLeft(){
        super.moveLeft();
        setHorizontalSpeed(-getMoveSpeed());
    }
    //Power up functions
    @Override
    public void powerUp(boolean poweredUp) {
        isPowered = poweredUp;
    }

}
