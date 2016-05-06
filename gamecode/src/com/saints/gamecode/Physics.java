package com.saints.gamecode;

import com.saints.gamecode.gameobjects.GameObject;
import com.saints.gamecode.interfaces.IPhysics;

//Singleton class that does basic Physics calculations
public class Physics implements IPhysics {

    //Sets the gravity of the world
    private final Vector2D GRAVITY = new Vector2D(0,-98.2f);

    //The only instance of this class
    private static final Physics instance = new Physics();


    private Physics (){
    }

    //Returns the instance of this singleton
    public static Physics getInstance(){
        return instance;
    }

    //Gets the acceleration caused by gravity given in a specified time (delta)
    public Vector2D getGravity(float delta){
        Vector2D deltaGravity = (Vector2D)GRAVITY.clone();
        deltaGravity.multiplyVector(delta);
        return deltaGravity;
    }

    //Checks if two objects have collided
    public boolean hasCollided(GameObject object1, GameObject object2){
        Position pos1 = object1.getPos();
        Position pos2 = object2.getPos();

        return(!(pos1.getX()+object1.getWidth()<pos2.getX()
                || pos1.getY()>pos2.getY()+object2.getHeight()
                || pos1.getY() + object1.getHeight()<pos2.getY()
                || pos1.getX()>pos2.getX()+object2.getWidth()));
    }
}
