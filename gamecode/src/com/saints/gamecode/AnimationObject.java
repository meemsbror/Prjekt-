package com.saints.gamecode;

/**
 * Created by admin on 2016-05-17.
 */
public class AnimationObject {
    private final String path;
    private final int animationFrames, numberOfAnimations;

    public AnimationObject(String path, int animationFrames, int numberOfAnimations){
        this.path = path;
        this.animationFrames = animationFrames;
        this.numberOfAnimations = numberOfAnimations;

    }
    public int getAnimationFrames() {
        return animationFrames;
    }

    public int getNumberOfAnimations() {
        return numberOfAnimations;
    }

    public String getPath() {
        return path;
    }
}
