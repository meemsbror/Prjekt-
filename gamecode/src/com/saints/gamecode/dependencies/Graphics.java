package com.saints.gamecode.dependencies;

import com.saints.gamecode.GameObject;

public interface Graphics {

    public void render();

    public void createObject(GameObject gameObject);

    public void moveObject(GameObject gameObject);
}

