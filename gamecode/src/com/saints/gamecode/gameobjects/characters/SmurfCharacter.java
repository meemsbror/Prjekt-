package com.saints.gamecode.gameobjects.characters;

<<<<<<< HEAD
import com.saints.gamecode.State;
=======
>>>>>>> 6f6a1aef60329138f18e199af53a6b793b4e38b8
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

<<<<<<< HEAD
    public SmurfCharacter(int x, int y) {
        //SmurfCharacter is always 128x128!
        //TODO Anpassa höjden och bredden till spriten.
        super(x, y, 128, 128);
        jumpSpeed = new Vector2D(0,15);
        straightRightAttack = new StraightAttack(x,y,50,50);
        straightLeftAttack = new StraightAttack(x,y,-50,50);
        setState(State.STALL);
    }
=======
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

>>>>>>> 6f6a1aef60329138f18e199af53a6b793b4e38b8

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

}
