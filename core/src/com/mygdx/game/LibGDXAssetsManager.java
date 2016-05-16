package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import java.util.Map;
import java.util.HashMap;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.saints.gamecode.interfaces.IAssetsManager;

//Handels all assets
public class LibGDXAssetsManager implements IAssetsManager{


    //Map that contains all animations
    private final Map<String, Animation []> animations;

    //LibGDX AssetManager that handels assets
    private final AssetManager assets = new AssetManager();

    public LibGDXAssetsManager(){
        animations = new HashMap<String, Animation[]>();
    }


    //Adds a new animation and saves them as an array. each array contains a different set of animation
    public void addAnimation(String filename, int animationFrames, int numberOfAnimations){
        Animation animation[] = new Animation[animationFrames];
        Texture img = new Texture(filename);

        //calculate the size of the images
        //4 is the number of animations and 6 is the number of frames in each animation, may vary later.
        TextureRegion[][] tmpFrames = TextureRegion.split(img,img.getWidth()/numberOfAnimations,img.getHeight()/animationFrames);

        for(int i = 0; i < animationFrames; i++){
            animation[i] = new Animation(1f/6f,tmpFrames[i]);
        }

        this.animations.put(filename,animation);

    }

    public void addTexture(String filename){
        assets.load(filename, Texture.class);
    }

    public Texture getTexture(String filename){
        return assets.get(filename,Texture.class);
    }

    public Animation [] getAnimation(String filename){
        return this.animations.get(filename);
    }
}
