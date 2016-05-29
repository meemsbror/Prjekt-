package com.saints.gamecode.interfaces;


import com.saints.gamecode.utils.AnimationObject;
import com.saints.gamecode.Entities.Background;
import com.saints.gamecode.Entities.CharacterPanel;

import java.util.List;

public interface IGraphics {

    void update (float delta, List<IEntity> gameObjects, Background background);

    void update (float delta, IEntity [][] IEntitys, CharacterPanel p1, CharacterPanel p2, Background background);

    void update (float delta, IEntity [][] IEntitys, CharacterPanel panel, Background background);

    void update (Background background);

    void addAnimation(AnimationObject animationObject);

    void addTexture(String path);

    int getScreenHeight();

    int getScreenWidth();

    void finishLoading();
}

