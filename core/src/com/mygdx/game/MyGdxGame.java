package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.saints.gamecode.gameobjects.GameObject;
import com.saints.gamecode.Arena;
import com.saints.gamecode.CharacterFactory;
import com.saints.gamecode.Position;


import java.util.ArrayList;
import java.util.List;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
    private Arena arena;

    List<Texture>  textures = new ArrayList<Texture>();

	@Override
	public void create () {
        batch = new SpriteBatch();
        LibGDXInput input = new LibGDXInput(Gdx.input);
        this.arena = new Arena(CharacterFactory.createCharacter(),CharacterFactory.createCharacter(), input);
        for(int i = 0; i < arena.getGameObjects().size(); i++){
            textures.add(new Texture(arena.getGameObjects().get(i).getImgPath()));
        }
    }

    public void renderGameObjects(){
        render();
    }

	@Override
	public void render () {
        if(textures.size() < arena.getGameObjects().size()){
            textures.add(new Texture(arena.getGameObjects().get(arena.getGameObjects().size()).getImgPath()));
        }
        for(int i = 0; i < arena.getGameObjects().size(); i++){
            textures.get(i).dispose();
            textures.set(i, new Texture(arena.getGameObjects().get(i).getImgPath()));
        }
        Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        for(int i = 0; i < arena.getGameObjects().size(); i++){
            batch.draw(textures.get(i), arena.getGameObjects().get(i).getPos().getX(), arena.getGameObjects().get(i).getPos().getY());
        }
		batch.end();

        System.out.println(Gdx.graphics.getDeltaTime());

        arena.update(Gdx.graphics.getDeltaTime());
	}

    @Override
    public void dispose(){
        batch.dispose();
    }
}
