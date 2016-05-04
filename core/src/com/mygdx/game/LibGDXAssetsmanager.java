package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import java.util.Map;
import java.util.HashMap;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class LibGDXAssetsmanager {


    private final Map<String, Animation []> animations;
    private final AssetManager assets = new AssetManager();

    public LibGDXAssetsmanager(){
        animations = new HashMap<String, Animation[]>();
    }


    public void addAnimation(String filename){
        Animation animation[] = new Animation[4];
        Texture img = new Texture(filename);

        //calculate the size of the images
        //4 is the number of animations and 6 is the number of frames in each animation, may vary later.
        TextureRegion[][] tmpFrames = TextureRegion.split(img,img.getWidth()/6,img.getHeight()/4);

        for(int i = 0; i < 4; i++){
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
