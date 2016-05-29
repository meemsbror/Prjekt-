package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {

	public static void main(String [] args){

        MyGdxGame myGdxGame = launch();

    }

	public static MyGdxGame launch () {
		MyGdxGame myGdxGame = new MyGdxGame();
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 720;
		config.width = 1280;
		new LwjglApplication(myGdxGame, config);
		return myGdxGame;
	}
}
