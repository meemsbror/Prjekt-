package com.saints.gamecode;

import com.saints.gamecode.gameobjects.GameObject;

import java.awt.event.KeyListener;
import java.util.List;

public interface Graphics {

    public void render();

    public void addKeyListener(KeyListener keyListener);

}

