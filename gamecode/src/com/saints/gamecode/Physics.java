package com.saints.gamecode;

import com.saints.gamecode.gameobjects.GameObject;

public class Physics {

    private final Vector2D GRAVITY = new Vector2D(0,0.92f);
    private Vector2D deltaGravity;
    private float delta;

    public Vector2D getGravity(float delta){
        deltaGravity = (Vector2D)GRAVITY.clone();
        deltaGravity.multiplyVector(delta);
        return deltaGravity;
    }

    public boolean hasColided(GameObject object1, GameObject object2){

        if(object1.getPos().getX()+object1.getPos().getX()<object2.getPos().getX() ||object2.getPos().getX()+object2.getWidth()<object1.getPos().getX()
                ||object1.getPos().getY()+object1.getHeight()<object2.getPos().getY() ||object2.getPos().getY()+object2.getHeight()<object1.getPos().getY()){
            return false;
        }else{
            return true;
        }
    }
    public void applyGravity(float delta, Vector2D vector){
        deltaGravity = (Vector2D)GRAVITY.clone();
        deltaGravity.multiplyVector(delta);
        vector.addVector(deltaGravity);
    }
}
