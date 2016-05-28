package com.saints.gamecode.interfaces;

import com.saints.gamecode.utils.Position;

public interface IEntity {

    void setPosition(float x, float y);

    Position getPosition();

    int getWidth();

    int getHeight();
}
