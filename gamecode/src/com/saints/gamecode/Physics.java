package com.saints.gamecode;

import com.saints.gamecode.gameobjects.GameObject;
import com.saints.gamecode.gameobjects.items.Platform;
import com.saints.gamecode.interfaces.IPhysics;

//Singleton class that does basic Physics calculations
public class Physics implements IPhysics {

    //Sets the gravity of the world
    private final Vector2D GRAVITY = new Vector2D(0,-300f);

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

    public boolean isBelowPlatform(GameObject object, Platform platform){
        //if ( ("X for any part of object"=="X for any part of platform")
        // AND ("Y for bottom of object"=<"Y for top of platform"
        // AND ("Y for bottom of object"<"Y for bottom of platform") ) {return true}
        if (       (object.getPos().getX()>platform.getX()-object.getWidth()) //o.X>p.X-o.W
                && (platform.getX()+platform.getWidth()>object.getPos().getX()) // p.X+p.W>o.X
                && (object.getPos().getY()<platform.getY())
                && (object.getPos().getY()>platform.getY()-60)) { //marginal is 60
            return true;
        }else{
            return false;
        }
    }

    public boolean isInAir(GameObject object, Platform platform, GameObject object2){
        //When walking outside of platform the character should fall down
        if( (object.getPos().getY()>platform.getY() //above platform
                && (hasCollided(object,object2)))) { return false;}
        else if (        (object.isAirborne()) //if already airborne, it is still airborne (until it is belowPlatform
                ||(object.getPos().getY()==platform.getY())
                &&  ((object.getPos().getX()<platform.getX()-object.getWidth()) //Outside to the left
                ||  (platform.getX()+platform.getWidth()<object.getPos().getX())) //Outside te the right
                ){
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
            Math.abs(object1Width);
        }
        if(object2Width < 0){
            pos2.setX(pos2.getX()+object2Width);
            Math.abs(object2Width);
        }

        return(!(pos1.getX()+object1Width<pos2.getX()
                || pos1.getY()>pos2.getY()+object2.getHeight()
                || pos1.getY() + object1.getHeight()<pos2.getY()
                || pos1.getX()>pos2.getX()+object2Width));
    }
}
