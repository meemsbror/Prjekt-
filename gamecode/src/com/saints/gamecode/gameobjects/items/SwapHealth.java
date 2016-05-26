package com.saints.gamecode.gameobjects.items;

import com.saints.gamecode.AnimationObject;

/**
 * Created by admin on 2016-04-05.
 */
public class SwapHealth extends Item {
    public SwapHealth(int x, int y, int width, int height, AnimationObject animationObject){
        super(x,y,width,height,animationObject);
    }

    public float getDuration() {
        return 0;
    }


}
