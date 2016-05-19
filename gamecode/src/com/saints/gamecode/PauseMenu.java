package com.saints.gamecode;

import com.saints.gamecode.interfaces.IEntity;

/**
 * Created by admin on 2016-05-19.
 */
public class PauseMenu implements IEntity {

    private AnimationObject animationObject;

    public AnimationObject getAnimationObject() {
        return animationObject;
    }

    public void setAnimationObject(AnimationObject animationObject) {
        this.animationObject = animationObject;
    }

    public PauseMenu(AnimationObject animationObject){
        this.animationObject = animationObject;
    }

    @Override
    public void setPosition(int x, int y) {

    }

    @Override
    public Position getPosition() {
        return null;
    }
}
