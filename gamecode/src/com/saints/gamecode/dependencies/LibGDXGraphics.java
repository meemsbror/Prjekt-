package com.saints.gamecode.dependencies;

import com.mygdx.game.MyGdxGame;
import com.mygdx.game.desktop.DesktopLauncher;
import com.saints.gamecode.Graphics;
import com.saints.gamecode.gameobjects.GameObject;

import java.util.List;


public class LibGDXGraphics implements Graphics {

    private final MyGdxGame myGdxGame;

    public LibGDXGraphics (){
        myGdxGame = new DesktopLauncher().launch();
    }

    public void create(){
        myGdxGame.create();
    }

    public void render(List<GameObject> gameObjects){
        myGdxGame.renderGameObjects(gameObjects);
    }

}
