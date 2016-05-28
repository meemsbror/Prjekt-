package com.saints.gamecode.Entities.gameobjects.items;

import com.saints.gamecode.AnimationObject;

public class AttackPower extends Item {
    private static final float DURATION = 5;
    public AttackPower(float x, float y, AnimationObject animationObject){
        super(x,y,60,60,animationObject);
    }


    public float getDuration(){
        return  DURATION;
    }
}
