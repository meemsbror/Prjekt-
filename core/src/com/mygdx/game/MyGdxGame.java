package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.saints.gamecode.State;
import com.saints.gamecode.Arena;
import com.saints.gamecode.CharacterFactory;
import com.saints.gamecode.gameobjects.characters.Character;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;

    private Map<State,Integer> map;

    private Arena arena;
    Character char1, char2;

    //Animation stuff
    private Texture img;
    private Animation [] p1Animations, p2Animations;

    //Elapsed time since start of game
    //TODO if pause button is implemented pause this timer!
    long startTime = System.currentTimeMillis();
    long elapsedTime;


	@Override
	public void create () {
        batch = new SpriteBatch();
        LibGDXInput input = new LibGDXInput(Gdx.input);
        char1 = CharacterFactory.createCharacter();
        char2 = CharacterFactory.createCharacter();
        this.arena = new Arena(char1,char2, input);

        //Initiate the different states
        initiateState();

        //Initiate what animations to be loaded (gameObjects 0 and 1 is always the players)
        p1Animations = createPlayerAnimation(char1);
        p2Animations = createPlayerAnimation(char2);
    }

    private Animation[] createPlayerAnimation(Character character) {

        Animation animations[] = new Animation[4];
        img = new Texture(char1.getSpriteSheetPath());

        //calculate the size of the images
        //4 is the number of animations and 6 is the number of frames in each animation, may vary later.
        TextureRegion[][] tmpFrames = TextureRegion.split(img,128,128);


        System.out.println(Arrays.deepToString(tmpFrames));


        for(int i = 0; i < 4; i++){
            animations[i] = new Animation(1f/6f,tmpFrames[i]);
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
        elapsedTime = (System.currentTimeMillis() - startTime);

        Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        for(int i = 0; i < arena.getGameObjects().size(); i++){
             batch.draw(p1Animations[map.get(char1.getState())].getKeyFrame((float)elapsedTime/1000, true), arena.getGameObjects().get(i).getPos().getX(), arena.getGameObjects().get(i).getPos().getY());
        }
		batch.end();

        arena.update();
	}

    private void initiateState(){
        map = new HashMap<State,Integer>();

        map.put(State.STALL, 0);
        map.put(State.WALK, 1);
        map.put(State.JUMP, 2);
        map.put(State.PUNCH, 3);

    }

    @Override
    public void dispose(){
        batch.dispose();
    }
}
