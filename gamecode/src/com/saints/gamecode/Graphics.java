package com.saints.gamecode;

import java.awt.event.KeyListener;
import java.util.List;

public interface Graphics {

    public void render(List<GameObject> gameObjects);

    public void addKeyListener(KeyListener keyListener);

}

