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


import java.util.List;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
    Texture smurf;
    private Arena arena;

    List<GameObject> gameObjects;
	
	@Override
	public void create () {
        batch = new SpriteBatch();
        smurf = new Texture("assets/pictures/smurf1.png");
        LibGDXInput input = new LibGDXInput(Gdx.input);
        this.arena = new Arena(CharacterFactory.createCharacter(),CharacterFactory.createCharacter(), input);
    }

    public void renderGameObjects(List<GameObject> gameObjects){
        this.gameObjects = gameObjects;
        render();
    }

	@Override
	public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        Position p1Pos = arena.getP1Position();
        batch.draw(smurf,p1Pos.getX(),p1Pos.getY());
        //for(GameObject go:gameObjects){
        //    batch.draw(smurf,go.getPos().getX(),go.getPos().getY());
        //}
		batch.end();

        arena.update();
	}

    @Override
    public void dispose(){
        batch.dispose();
    }
}
