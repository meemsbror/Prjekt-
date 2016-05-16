package com.saints.gamecode.gameobjects.items;

/**
 * Created by admin on 2016-04-05.
 */
public class AttackPower extends Item {

    //Duration is the same over all AttackPower items
    private static final float DURATION = 5;

    //Todo fix the imagepath :3
    private static final String imgPath = "the imagePath";


    public AttackPower(int x, int y, int width, int height){
        super(x,y,width,height);
    }

    @Override
    public String getSpriteSheet() {
        return imgPath;
    }

    public float getDuration(){
        return  DURATION;
    }
}
