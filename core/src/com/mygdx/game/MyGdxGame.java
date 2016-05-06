package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.saints.gamecode.State;
import com.saints.gamecode.Arena;
import com.saints.gamecode.CharacterFactory;
import com.saints.gamecode.gameobjects.characters.Character;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;

    private Map<State,Integer> map;

    private Arena arena;
    private LibGDXAssetsManager assetsmanager;
    Character char1, char2;

    //Animation stuff
    private Texture img;
    private Animation [] p1Animations, p2Animations;

    //Elapsed time since start of game
    //TODO if pause button is implemented pause this timer!
    float elapsedTime;

    List<Texture>  textures = new ArrayList<Texture>();


	@Override
	public void create () {
        batch = new SpriteBatch();
        LibGDXInput input = new LibGDXInput(Gdx.input);
        this.assetsmanager = new LibGDXAssetsManager();
        LibGDXGraphics graphics = new LibGDXGraphics(batch, assetsmanager);
        this.arena = new Arena(CharacterFactory.createCharacter("Smurf"),CharacterFactory.createCharacter("Smurf"), input, graphics);
   }

	@Override
	public void render () {
        elapsedTime = elapsedTime + Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Updates the game and sends the time between last frame
        arena.update(Gdx.graphics.getDeltaTime());
	}

    @Override
    public void dispose(){
        batch.dispose();
        for(Texture tmp : textures){
            tmp.dispose();
        }
    }
}
