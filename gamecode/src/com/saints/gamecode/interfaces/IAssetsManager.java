package com.saints.gamecode.interfaces;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.saints.gamecode.AnimationObject;

public interface IAssetsManager {

    public void addAnimation(AnimationObject filename);

    public void addTexture(String filename);

    public Object getTexture(String filename);

    public Object [] getAnimation(String filename);
}
