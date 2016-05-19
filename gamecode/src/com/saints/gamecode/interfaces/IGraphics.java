package com.saints.gamecode.interfaces;


import com.saints.gamecode.AnimationObject;
import com.saints.gamecode.gameobjects.GameObject;

import java.util.List;

public interface IGraphics {

    void update (float delta, List<IEntity> gameObjects);

    void addAnimation(AnimationObject animationObject);

    void addTexture(String path);
}

