package com.saints.gamecode;

import com.saints.gamecode.AnimationObject;
import com.saints.gamecode.CharacterPanel;
import com.saints.gamecode.interfaces.IEntity;
import com.saints.gamecode.interfaces.IGraphics;
import java.util.List;

public class GraphicsSim implements IGraphics{

    @Override
    public void update(float delta, List<IEntity> entities){

    }

    @Override
    public void update(float delta, IEntity[][] entities, CharacterPanel p1, CharacterPanel p2, Background background){

    }

    @Override
    public void update(Background background) {

    }

    @Override
    public void addAnimation(AnimationObject animationObject) {

    }

    @Override
    public void addTexture(String path) {

    }

    @Override
    public int getScreenWidth(){
        return 0;
    }

    @Override
    public void finishLoading() {

    }

    @Override
    public int getScreenHeight(){
        return 0;
    }

    @Override
    public void update(Background background){

    }

}
