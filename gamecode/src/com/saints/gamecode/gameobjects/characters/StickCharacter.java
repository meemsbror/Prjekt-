package com.saints.gamecode.gameobjects.characters;

import com.saints.gamecode.*;
import com.saints.gamecode.gameobjects.characters.attacks.StraightAttack;
import com.saints.gamecode.gameobjects.GameObject;


public class StickCharacter extends Character {

    private final Physics physics;

    //the initial speed that a character jumps with
    private final Vector2D jumpSpeed = new Vector2D(0, 300);

    //The time until next attack
    private float attackCD = 0;

    //Static value of how fast this character attacks
    private final float ATTACKSPEED = 0.5f;

    //Straight attack is the attack going straight to either side of the character.
    public StraightAttack straightAttack;

    // Unique HP for every Character
    private int hitPoints = 50;


    //The ammount of damage this character has and the increasage in damage while powered up
    int DAMAGE = 5;


    public StickCharacter(boolean isPlayer1) {
        //Original width and height 100*256
        super(100, 256, new AnimationObject("assets/pictures/StickManSpriteSheet.png", 6, 4, 1f/6f),200, isPlayer1);
        straightAttack = new StraightAttack(133, 87, new AnimationObject("assets/pictures/SmurfAttackSprite.png",6,1,1f/6f));
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
        straightAttack.setPosition(getPos().getX() + 82, getPos().getY() + 113);
    }

    public Vector2D getJumpSpeed(){
        return jumpSpeed;
    }

    public void jump(){
        setDoubleJumped((isAirborne()) ? true : false);
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
