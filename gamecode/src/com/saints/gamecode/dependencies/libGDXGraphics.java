package com.saints.gamecode.dependencies;

import com.mygdx.game.MyGdxGame;
import com.mygdx.game.desktop.DesktopLauncher;
import com.saints.gamecode.GameObject;
import com.saints.gamecode.interfaces.Graphics;

import java.awt.event.KeyListener;
import java.util.List;


public class LibGDXGraphics implements Graphics {

    private final MyGdxGame myGdxGame;
    DesktopLauncher desktopLauncher;

    public LibGDXGraphics (){
        desktopLauncher = new DesktopLauncher();
        myGdxGame = desktopLauncher.launch();
    }

    public void create(){
        myGdxGame.create();
    }

    public void render(List<GameObject> gameObjects){
        myGdxGame.renderGameObjects(gameObjects);
    }

    public void addKeyListener(KeyListener keyListener){
    }

}
