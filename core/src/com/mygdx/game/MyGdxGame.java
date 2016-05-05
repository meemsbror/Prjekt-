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


    //Elapsed time since start of game
    //TODO if pause button is implemented pause this timer!
    float elapsedTime;

    List<Texture>  textures = new ArrayList<Texture>();


	@Override
	public void create () {
        batch = new SpriteBatch();
        LibGDXInput input = new LibGDXInput(Gdx.input);
        char1 = CharacterFactory.createCharacter("Smurf");
        char2 = CharacterFactory.createCharacter("Smurf");


        this.assetsmanager = new LibGDXAssetsManager();
        LibGDXGraphics graphics = new LibGDXGraphics(batch, assetsmanager);
        this.arena = new Arena(char1,char2, input, graphics);
   }

	@Override
	public void render () {
        elapsedTime = elapsedTime + Gdx.graphics.getDeltaTime();

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
