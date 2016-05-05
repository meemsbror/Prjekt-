package com.saints.gamecode.interfaces;


import com.saints.gamecode.gameobjects.GameObject;

import java.util.List;

public interface IGraphics {

    void update (float delta, List<GameObject> gameObjects);

    void addAnimation(String filename);

    void addTexture(String filename);
}

