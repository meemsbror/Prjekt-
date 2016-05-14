package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.saints.gamecode.Game;
import com.saints.gamecode.State;
import com.saints.gamecode.scenes.Arena;
import com.saints.gamecode.CharacterFactory;
import com.saints.gamecode.gameobjects.characters.Character;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
    //Elapsed time since start of game
    //TODO if pause button is implemented pause this timer!
    float elapsedTime;

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
