package Entities.gameobjects.items;

import com.saints.gamecode.AnimationObject;
import Entities.gameobjects.GameObject;

public abstract class Item extends GameObject{


    public Item (float x, float y, int width, int height, AnimationObject animationObject){
        super(width,height, animationObject);
        setPosition(x,y);
    }

}
