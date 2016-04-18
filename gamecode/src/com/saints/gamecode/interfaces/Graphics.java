package com.saints.gamecode.interfaces;

import java.awt.event.KeyListener;
import java.util.List;
import com.saints.gamecode.gameobjects.GameObject;

public interface Graphics {

    public void render(List<GameObject> gameObjects);

    public void addKeyListener(KeyListener keyListener);

}

