package com.saints.gamecode.utils;

import com.saints.gamecode.Entities.gameobjects.GameObject;
import com.saints.gamecode.Entities.gameobjects.Platform;
import com.saints.gamecode.interfaces.IPhysics;

//Singleton class that does basic Physics calculations
public class Physics implements IPhysics {

    //Sets the gravity of the world
    private final Vector2D GRAVITY = new Vector2D(0,-300f);

    //The only instance of this class
    private static final Physics instance = new Physics();


    //Private since this is a singleton.
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

    public boolean isStandingOnPlatform(GameObject object, Platform platform){
        if (       (object.getPos().getX()>platform.getX()-object.getWidth()) //o.X>p.X-o.W
                && (platform.getX()+platform.getWidth()>object.getPos().getX()) // p.X+p.W>o.X
                && (object.getPos().getY()<platform.getY())
                && (object.getPos().getY()>platform.getY()-platform.getHeight())) { //marginal is Height
            return true;
        }else{
            return false;
        }
    }

    public boolean isOutsidePlatform(GameObject object, Platform platform, GameObject gameObject2){
        //When walking outside of platform the character should fall down
         if (       (object.isAirborne()) //if already airborne, it is still airborne (until it is belowPlatform
                ||  (object.getPos().getY()==platform.getY())
                &&  ((object.getPos().getX()<platform.getX()-object.getWidth()) //Outside to the left
                ||  (platform.getX()+platform.getWidth()<object.getPos().getX())) //Outside te the right
                 && !(hasCollided(object,gameObject2))
                 || (object.getPos().getY()>720) //if object over screen its probably in air
                 ){ //
            return true;
        } else {
            return false;
        }
    }

    //Checks if two objects have collided
    public boolean hasCollided(GameObject object1, GameObject object2){
        Position pos1 = object1.getPos();
        Position pos2 = object2.getPos();
        int object1Width = object1.getWidth();
        int object2Width = object2.getWidth();
        if(object1Width < 0){
            pos1.setX(pos1.getX()+object1Width);
            object1Width = Math.abs(object1Width);
        }
        if(object2Width < 0){
            pos2.setX(pos2.getX()+object2Width);
            object2Width = Math.abs(object2Width);
        }

        return(!(pos1.getX()+object1Width<pos2.getX()
        //Checks if the object is on either side of the other. If it is not, it is inside.
                || pos1.getY()>pos2.getY()+object2.getHeight()
                || pos1.getY() + object1.getHeight()<pos2.getY()
                || pos1.getX()>pos2.getX()+object2Width));
    }
}
