package com.saints.gamecode.interfaces;

import com.saints.gamecode.utils.AnimationObject;

public interface IAssetsManager {

    public void addAnimation(AnimationObject filename);

    public void addTexture(String filename);

    public Object getTexture(String filename);

    public Object [] getAnimation(String filename);

    void finishLoading();

}
