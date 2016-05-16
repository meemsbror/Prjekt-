package com.saints.gamecode.interfaces;


import com.saints.gamecode.gameobjects.GameObject;

import java.util.List;

public interface IGraphics {

    void update (float delta, List<GameObject> gameObjects);

    void addAnimation(String filename, int animationFrames, int numberOfAnimations);

    void addTexture(String filename);
}

