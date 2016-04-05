package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public MyGdxGame launch () {
		MyGdxGame myGdxGame = new MyGdxGame();
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(myGdxGame, config);
		return myGdxGame;
	}
}
