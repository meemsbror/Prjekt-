package com.saints.gamecode.interfaces;

import com.badlogic.gdx.graphics.Texture;

public interface IAssetsManager {


    public void addAnimation(String filename);


    public void addTexture(String filename);


    public Texture getTexture(String filename);
}
