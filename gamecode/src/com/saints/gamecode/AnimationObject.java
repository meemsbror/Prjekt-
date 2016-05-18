package com.saints.gamecode;

public class AnimationObject {

    //AnimationObject contains path to an image and the number of frames/animations it contains. It is simply a bundle
    //of the properties of an animation to simplify connection.



    private final String path;
    private final int animationFrames, numberOfAnimations;
    private float animationSpeed;


    public AnimationObject(String path, int animationFrames, int numberOfAnimations, float animationSpeed){
        this.path = path;
        this.animationFrames = animationFrames;
        this.numberOfAnimations = numberOfAnimations;
        this.animationSpeed = animationSpeed;


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
    public float getAnimationSpeed() {
        return animationSpeed;
    }

    public void setAnimationSpeed(float animationSpeed) {
        this.animationSpeed = animationSpeed;
    }
}
