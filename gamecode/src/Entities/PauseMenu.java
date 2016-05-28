package Entities;

import com.saints.gamecode.AnimationObject;
import com.saints.gamecode.Direction;
import com.saints.gamecode.Position;
import com.saints.gamecode.interfaces.IEntity;
import com.saints.gamecode.interfaces.IKeyInput;

public class PauseMenu implements IEntity {

    private AnimationObject animationObject;
    private final int width = 460;
    private final int height = 1000;

    private int currentPauseOption = 0;
    private float pauseTimer = 0;
    private boolean paused = false;

    public AnimationObject getAnimationObject() {
        return animationObject;
    }

    public void setAnimationObject(AnimationObject animationObject) {
        this.animationObject = animationObject;
    }

    public PauseMenu(AnimationObject animationObject){
        this.animationObject = animationObject;
    }

    @Override
    public void setPosition(float x, float y) {

    }

    @Override
    public Position getPosition() {
        return null;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public int getCurrentPauseOption() {
        return currentPauseOption;
    }

    public boolean updatePaused(float delta, IKeyInput input){
        pauseTimer += delta;
        if(pauseTimer > 0.3){
            if(input.isKeyPressed(Direction.SELECT)) {
                pauseTimer = 0;
                if(currentPauseOption == 0 || paused == false){
                    paused = !paused;
                }else if(currentPauseOption == 1){
                    return true;
                }else if(currentPauseOption == 2){
                    System.exit(0);
                }
            }else if(input.isKeyPressed(Direction.P2DIVE) || input.isKeyPressed(Direction.P1DIVE)){
                increaseCurrentPausePosition();
                pauseTimer = 0;
            }else if(input.isKeyPressed(Direction.P1JUMP) || input.isKeyPressed(Direction.P2JUMP)){
                decreaseCurrentPausePosition();
                pauseTimer = 0;
            }
        }
        return false;
    }
    public void increaseCurrentPausePosition(){
        currentPauseOption = (currentPauseOption+1)%3;
    }
    public void decreaseCurrentPausePosition(){
        currentPauseOption = currentPauseOption-1;
        if(currentPauseOption == -1){
            currentPauseOption = 2;
        }
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused, float delta) {
        pauseTimer += delta;
        if(pauseTimer > 0.3 && paused) {
            this.paused = paused;
            pauseTimer = 0;
        }
    }
    public void forcePaused(boolean paused){
        this.paused = paused;
    }

}
