package com.saints.gamecode.dependencies;

import com.saints.gamecode.*;

public interface Graphics {

    public void render();


    public void createObject(GameObject gameObject);

    public void moveObject(GameObject gameObject);

    void setArena();

    void setMap();
}

