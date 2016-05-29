package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.saints.gamecode.controllers.Game;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;

    private Game game;


	@Override
	public void create () {
        batch = new SpriteBatch();
        LibGDXInput input = new LibGDXInput(Gdx.input);
        LibGDXAssetsManager assetsmanager = new LibGDXAssetsManager();
        LibGDXGraphics graphics = new LibGDXGraphics(batch, assetsmanager);
        this.game = new Game(input,graphics);

   }

	@Override
	public void render () {
        //Updates the game and sends the time between last frame
        game.update(Gdx.graphics.getDeltaTime());
	}

    @Override
    public void dispose(){
        batch.dispose();
    }
}
