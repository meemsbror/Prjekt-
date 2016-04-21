package com.saints.gamecode;

public class Physics {

    private final Vector2D GRAVITY = new Vector2D(0,0.92f);
    private Vector2D deltaGravity;
    private float delta;

    public void applyGravity(float delta, Vector2D vector){
        deltaGravity = (Vector2D)GRAVITY.clone();
        deltaGravity.multiplyVector(delta);
        vector.addVector(deltaGravity);
    }

}
