package com.mygdx.game;

import com.saints.gamecode.Entities.Background;
import com.saints.gamecode.Entities.CharacterPanel;
import com.saints.gamecode.Entities.HealthBar;
import com.saints.gamecode.Entities.PauseMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.saints.gamecode.Entities.gameobjects.GameObject;
import com.saints.gamecode.Entities.gameobjects.characters.Character;
import com.saints.gamecode.Entities.gameobjects.items.AttackPower;
import com.saints.gamecode.Entities.gameobjects.items.Item;
import com.saints.gamecode.utils.AnimationObject;
import com.saints.gamecode.utils.Position;
import com.saints.gamecode.interfaces.IEntity;
import com.saints.gamecode.interfaces.IGraphics;
import com.saints.gamecode.utils.State;

import java.util.HashMap;
import java.util.Map;

import java.util.List;

public class LibGDXGraphics implements IGraphics{

    private final SpriteBatch batch;
    private final LibGDXAssetsManager assetsmanager;
    private Map<State, Integer> map;
    //For animations
    private float elapsedTime = 0;
    //AttackTime
    private float p1AttackTime = 0;
    private float p2AttackTime = 0;
    private TextureRegion tmpRegion;


    public LibGDXGraphics(SpriteBatch batch, LibGDXAssetsManager assetsmanager){

        this.batch = batch;
        this.assetsmanager = assetsmanager;
        initiateState();
    }


    //Arena update!
    @Override
    public void update(float delta, List<IEntity> gameObjects, Background background){

        elapsedTime = elapsedTime + delta;


        Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

        //Background of current map.
        batch.draw(assetsmanager.getTexture(background.getImgPath()),0, 0 ,1280, 720);

        //Loops through all gameObjects
        for(int i = 0; i<gameObjects.size(); i++){
            if(gameObjects.get(i)instanceof Map){
                Map map = (Map)gameObjects.get(i);
                //batch.draw(assetsmanager.getTexture(map.getMapPath()),0,0);
            } else if(gameObjects.get(i)instanceof Character){
                Character character = (Character)gameObjects.get(i);
                drawCharacter(character, delta);

            }
            else if(gameObjects.get(i) instanceof Item){
                Item gameObject = (Item)gameObjects.get(i);
                int temp;
               if(gameObject instanceof AttackPower){
                    temp = 0;
                }else{
                    temp = 1;
                }
                batch.draw(assetsmanager.getAnimation(gameObject.getAnimationObject().getPath())[temp].getKeyFrame(elapsedTime, true),gameObject.getPos().getX(),gameObject.getPos().getY(), gameObject.getWidth(),gameObject.getHeight());


            }else if(gameObjects.get(i) instanceof PauseMenu) {
                PauseMenu gameObject = (PauseMenu) gameObjects.get(i);
                TextureRegion tmpFrame = assetsmanager.getAnimation(gameObject.getAnimationObject().getPath())[gameObject.getCurrentPauseOption()].getKeyFrame(elapsedTime);
                batch.draw(tmpFrame, Gdx.graphics.getWidth()/2-tmpFrame.getRegionWidth()/2 ,Gdx.graphics.getHeight()/2-tmpFrame.getRegionHeight()/2);


            }else if (gameObjects.get(i) instanceof HealthBar){
                HealthBar gameObject = (HealthBar)gameObjects.get(i);
                TextureRegion tmpFrame = assetsmanager.getAnimation(gameObject.getAnimationObject1().getPath())[0].getKeyFrame(elapsedTime);
                // fix a position for bottom rectangle
                batch.draw(tmpFrame, gameObject.getPosition().getX(),
		                gameObject.getPosition().getY(),getScreenWidth()/2,getScreenHeight()/10);



                TextureRegion tmpFrame2 = assetsmanager.getAnimation(gameObject.getAnimationObject2().getPath())[0].getKeyFrame(elapsedTime);


	           batch.draw(tmpFrame2, (gameObject.getPosition().getX()),
	                  gameObject.getPosition().getY(), gameObject.getWidth(), getScreenHeight()/10);
            }
        }
        batch.end();
    }

    //Characterselect update!
    @Override
    public void update(float delta, IEntity [][] IEntities, CharacterPanel p1, CharacterPanel p2, Background background){
        Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        batch.draw(assetsmanager.getTexture(background.getImgPath()), 0,0);


        for(int i = 0; i < IEntities.length; i++){
            for(int j = 0; j < IEntities[i].length; j++){
                CharacterPanel panel = (CharacterPanel) IEntities[i][j];
                Position pos = panel.getPosition();
                batch.draw(assetsmanager.getTexture(panel.getImgPath()), pos.getX(), pos.getY());
            }
        }


        Position p1Pos = p1.getPosition();
        Position p2Pos = p2.getPosition();

        batch.draw(assetsmanager.getTexture(p1.getImgPath()), p1Pos.getX(), p1Pos.getY());
        batch.draw(assetsmanager.getTexture(p2.getImgPath()), p2Pos.getX(), p2Pos.getY());


        batch.end();
    }

    //Map select update!
    @Override
    public void update(float delta, IEntity [][] IEntities, CharacterPanel ppanel, Background background){
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(assetsmanager.getTexture(background.getImgPath()), 0,0);


        for(int i = 0; i < IEntities.length; i++){
            for(int j = 0; j < IEntities[i].length; j++){
                CharacterPanel panel = (CharacterPanel) IEntities[i][j];
                Position pos = panel.getPosition();
                batch.draw(assetsmanager.getTexture(panel.getImgPath()), pos.getX(), pos.getY(), 400,200);
            }
        }


        Position ppanelPos = ppanel.getPosition();

        batch.draw(assetsmanager.getTexture(ppanel.getImgPath()), ppanelPos.getX(), ppanelPos.getY());


        batch.end();
    }

    //Game over screen update!
	@Override
	public void update(Background background) {
		batch.begin();
		batch.draw(assetsmanager.getTexture(background.getImgPath()),0,0,1280,720);
		batch.end();
	}

	public void addAnimation(AnimationObject animationObject){
        assetsmanager.addAnimation(animationObject);
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
    public void drawCharacter(Character character, float delta){
        //The current animation frame of the character
        tmpRegion = assetsmanager.getAnimation(character.getAnimationObject().getPath())[map.get(character.getState())].getKeyFrame(elapsedTime, true);


        //See if it is flipped, if it is flip it.
        if(!tmpRegion.isFlipX()){
            tmpRegion.flip(true, false);
        }

        //if character is facing right, draw the character as it is.
        if(!character.isFacingRight()){
            batch.draw(tmpRegion, character.getPos().getX(), character.getPos().getY(), character.getWidth(), character.getHeight());
            if(character.getState() == State.PUNCH) {
                punch(character, delta);
            }


            //If character is facing left, flip the immage to the right direction again.
        }else{
            tmpRegion.flip(true, false);
            batch.draw(tmpRegion, character.getPos().getX(), character.getPos().getY(), character.getWidth(), character.getHeight());

            ///If the character is punching draw the punch aswell.
            if(character.getState() == State.PUNCH){
                punch(character, delta);
            }
        }
    }


    public void punch(Character character, float delta){
        GameObject attack = character.getStraightAttack();
        if(character.isP1()) {
            p1AttackTime += delta;
            drawPunch(attack, p1AttackTime);
        }else if(!character.isP1()){
            p2AttackTime += delta;
            drawPunch(attack, p2AttackTime);
        }
    }
    public void drawPunch(GameObject attack,float attackTime) {
        batch.draw(assetsmanager.getAnimation(attack.getAnimationObject().getPath())[0].getKeyFrame(attackTime, true), attack.getPos().getX(), attack.getPos().getY(), attack.getWidth(), attack.getHeight());
    }


    @Override
    public int getScreenHeight() {
        return 720;
    }

    @Override
    public int getScreenWidth() {
        return 1280;
    }

    @Override
    public void finishLoading(){
        assetsmanager.finishLoading();
    }
}

