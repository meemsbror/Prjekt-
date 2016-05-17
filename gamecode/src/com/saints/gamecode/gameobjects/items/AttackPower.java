package com.saints.gamecode.gameobjects.items;

import com.saints.gamecode.AnimationObject;

/**
 * Created by admin on 2016-04-05.
 */
public class AttackPower extends Item {
    private static final float DURATION = 5;
    public AttackPower(int x, int y, int width, int height, AnimationObject animationObject){
        super(x,y,width,height,animationObject);
    }


    public float getDuration(){
        return  DURATION;
    }
}
