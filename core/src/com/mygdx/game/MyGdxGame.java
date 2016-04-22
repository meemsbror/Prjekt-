package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.saints.gamecode.gameobjects.GameObject;
import com.saints.gamecode.Arena;
import com.saints.gamecode.CharacterFactory;
import com.saints.gamecode.Position;
import com.saints.gamecode.gameobjects.characters.*;
import com.saints.gamecode.gameobjects.characters.Character;


import java.util.ArrayList;
import java.util.List;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
    private Arena arena;
    private Texture img;
    private TextureRegion [][] animationFrames;
    private Animation [] p1Animations, p2Animations;
    Character char1, char2;
    float elapsedTime;


	@Override
	public void create () {
        batch = new SpriteBatch();
        LibGDXInput input = new LibGDXInput(Gdx.input);
        char1 = CharacterFactory.createCharacter();
        char2 = CharacterFactory.createCharacter();
        this.arena = new Arena(char1,char2, input);

        //Initiate what animations to be loaded (gameObjects 0 and 1 is always the players)
        p1Animations = createPlayer(char1);
        p2Animations = createPlayer(char2);
    }

    private Animation[] createPlayer(Character character) {

        Animation animations[] = new Animation[4];
        img = new Texture(char1.getSpriteSheetPath());

        //calculate the size of the images
        //4 is the number of animations and 6 is the number of frames in each animation, may vary later.
        TextureRegion[][] tmpFrames = TextureRegion.split(img,img.getWidth()/6,img.getHeight()/4);

        animationFrames = new TextureRegion[6][4];
        int index = 0;

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 6; j++){
                animationFrames[index++][i] = tmpFrames[j][i];
            }
        animations[i] = new Animation(1f/12f, animationFrames[i]);
        }
        return  animations;
    }

    public void renderGameObjects(){
       /* if(sprites.size() < arena.getGameObjects().size()){
            sprites.add(new Sprite(new Texture(arena.getGameObjects().get(arena.getGameObjects().size()).getImgPath())));
        }*/
    }

	@Override
	public void render () {
        renderGameObjects();
        elapsedTime += Gdx.graphics.getDeltaTime();

        Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        for(int i = 0; i < arena.getGameObjects().size(); i++){
            batch.draw(p1Animations[translateState(arena,char1.getState())].getKeyFrame(elapsedTime), arena.getGameObjects().get(i).getPos().getX(), arena.getGameObjects().get(i).getPos().getY());
        }
		batch.end();

        arena.update();
	}

    @Override
    public void dispose(){
        batch.dispose();
    }
}
