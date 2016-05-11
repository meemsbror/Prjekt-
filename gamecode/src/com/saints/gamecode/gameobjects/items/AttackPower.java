package com.saints.gamecode.gameobjects.items;

/**
 * Created by admin on 2016-04-05.
 */
public class AttackPower extends Item {
    private static final float DURATION = 5;
    public AttackPower(int x, int y, int width, int height){
        super(x,y,width,height);
    }
    public static float getDuration(){
        return  DURATION;
    }
}
