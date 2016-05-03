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

        if(object1.getPos().getX()+object1.getPos().getX()<object2.getPos().getX() ||object2.getPos().getX()+object2.getWidth()<object1.getPos().getX()
                ||object1.getPos().getY()+object1.getHeight()<object2.getPos().getY() ||object2.getPos().getY()+object2.getHeight()<object1.getPos().getY()){
            return false;
        }else{
            return true;
        }
    }
}
