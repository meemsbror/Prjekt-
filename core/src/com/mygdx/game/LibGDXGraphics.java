package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.saints.gamecode.*;
import com.saints.gamecode.gameobjects.GameObject;
import com.saints.gamecode.gameobjects.characters.Character;
import com.saints.gamecode.gameobjects.items.Item;
import com.saints.gamecode.interfaces.IEntity;
import com.saints.gamecode.interfaces.IGraphics;

import java.util.HashMap;
import java.util.Map;

import java.util.List;

import static com.badlogic.gdx.Gdx.graphics;

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

    @Override
    public void update(float delta, List<IEntity> gameObjects){

        elapsedTime = elapsedTime + delta;


        Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        for(int i = 0; i<gameObjects.size(); i++){
            if(gameObjects.get(i)instanceof Character){
                Character character = (Character)gameObjects.get(i);
                drawCharacter(character, delta);
            }
            else if(gameObjects.get(i) instanceof Item){
                GameObject gameObject = (Item)gameObjects.get(i);
                Position pos = gameObject.getPos();
                batch.draw(assetsmanager.getAnimation(gameObject.getAnimationObject().getPath())[0].getKeyFrame(elapsedTime, true),pos.getX(),pos.getY());

            }else if(gameObjects.get(i) instanceof PauseMenu) {
                PauseMenu gameObject = (PauseMenu) gameObjects.get(i);
                TextureRegion tmpFrame = assetsmanager.getAnimation(gameObject.getAnimationObject().getPath())[gameObject.getCurrentPauseOption()].getKeyFrame(elapsedTime);
                batch.draw(tmpFrame, Gdx.graphics.getWidth()/2-tmpFrame.getRegionWidth()/2 ,Gdx.graphics.getHeight()/2-tmpFrame.getRegionHeight()/2);

            }else if (gameObjects.get(i) instanceof HealthBar){
                HealthBar gameObject = (HealthBar)gameObjects.get(i);
                TextureRegion tmpFrame = assetsmanager.getAnimation(gameObject.getAnimationObject1().getPath())[0].getKeyFrame(elapsedTime);
                batch.draw(tmpFrame, gameObject.getPosition().getX(), gameObject.getPosition().getY());

                TextureRegion tmpFrame2 = assetsmanager.getAnimation(gameObject.getAnimationObject2().getPath())[0].getKeyFrame(elapsedTime);

	            // fix a position for bottom rectangle      \this/ == HALF SIZE (should be)
	            batch.draw(tmpFrame2, ((getScreenWidth()/2) -441), getScreenHeight()-80);
            }
        }
        batch.end();
    }

    @Override
    public void update(float delta, IEntity [][] IEntities, CharacterPanel p1, CharacterPanel p2){
        Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

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
                punch(character, delta, -1);
            }


            //If character is facing left, flip the immage to the right direction again.
        }else{
            tmpRegion.flip(true, false);
            batch.draw(tmpRegion, character.getPos().getX(), character.getPos().getY(), character.getWidth(), character.getHeight());

            ///If the character is punching draw the punch aswell.
            if(character.getState() == State.PUNCH){
                punch(character, delta, 1);
            }
        }
    }


    public void punch(Character character, float delta, float negative){
        GameObject attack = character.getStraightAttack();
        if(character.isP1()) {
            //If the character is punching draw the punch aswell.
            p1AttackTime += delta;
            drawPunch(attack, p1AttackTime, negative);
        }else{
            p2AttackTime += delta;
            drawPunch(attack, p2AttackTime, negative);
        }
    }
    public void drawPunch(GameObject attack,float attackTime, float negative) {
        batch.draw(assetsmanager.getAnimation(attack.getAnimationObject().getPath())[0].getKeyFrame(attackTime, true), attack.getPos().getX(), attack.getPos().getY(), negative * attack.getWidth(), attack.getHeight());
    }


    @Override
    public int getScreenHeight() {
        return graphics.getHeight();
    }

    @Override
    public int getScreenWidth() {
        return graphics.getWidth();
    }

    @Override
    public void finishLoading(){
        assetsmanager.finishLoading();
    }
}

