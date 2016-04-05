package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.saints.gamecode.GameObject;
import com.saints.gamecode.characters.SmurfCharacter;

import java.util.List;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
    Texture smurf;

    List<GameObject> gameObjects;
	
	@Override
	public void create () {
        batch = new SpriteBatch();
        smurf = new Texture("assets/pictures/smurf1.png");
    }


    public void renderGameObjects(List<GameObject> gameObjects){
        this.gameObjects = gameObjects;
    }

	@Override
	public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        for(GameObject go:gameObjects){
            batch.draw(smurf,go.getPos().getX(),go.getPos().getY());
        }
		batch.end();
	}

    @Override
    public void dispose(){
        batch.dispose();
    }
}
