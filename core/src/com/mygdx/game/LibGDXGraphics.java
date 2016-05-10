package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.saints.gamecode.Position;
import com.saints.gamecode.State;
import com.saints.gamecode.gameobjects.GameObject;
import com.saints.gamecode.gameobjects.characters.Character;
import com.saints.gamecode.interfaces.IGraphics;

import java.util.HashMap;
import java.util.Map;

import java.util.List;

public class LibGDXGraphics implements IGraphics{

    private final SpriteBatch batch;
    private final LibGDXAssetsManager assetsmanager;
    private Map<State, Integer> map;
    private float elapsedTime = 0;
    private TextureRegion tmpRegion;


    public LibGDXGraphics(SpriteBatch batch, LibGDXAssetsManager assetsmanager){

        this.batch = batch;
        this.assetsmanager = assetsmanager;
        initiateState();
    }

    public void update(float delta, List<GameObject> gameObjects){

        elapsedTime = elapsedTime + delta;

        Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        for(int i = 0; i<gameObjects.size(); i++){
            if(gameObjects.get(i)instanceof Character){
                Character character = (Character)gameObjects.get(i);
                //The current animation frame of the character
                tmpRegion = assetsmanager.getAnimation(character.getSpriteSheetPath())[map.get(character.getState())].getKeyFrame(elapsedTime, true);

                //See if it is flipped, if it is flip it.
                if(!tmpRegion.isFlipX())
                    tmpRegion.flip(true, false);

                //if character is facing right, draw the character as it is.
                if(!character.isFacingRight()){
                    batch.draw(tmpRegion, character.getPos().getX(), character.getPos().getY());

                //If character is facing left, flip the immage to the right direction again.
                }else{
                    tmpRegion.flip(true, false);
                    batch.draw(tmpRegion, character.getPos().getX(), character.getPos().getY());
                }
            }
            else{
                GameObject gameObject = gameObjects.get(i);
                Position pos = gameObject.getPos();
                batch.draw(assetsmanager.getTexture(gameObject.getImgPath()),pos.getX(),pos.getY());
            }
        }
        batch.end();
    }

    public void addAnimation(String filename){
        assetsmanager.addAnimation(filename);
    }

    public void addTexture(String filename){
        assetsmanager.addTexture(filename);
    }

    private void initiateState(){
        map = new HashMap<State,Integer>();

        map.put(State.STALL, 0);
        map.put(State.WALK, 1);
        map.put(State.JUMP, 2);
        map.put(State.PUNCH, 3);
    }
}
