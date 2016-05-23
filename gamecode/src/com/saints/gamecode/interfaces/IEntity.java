package com.saints.gamecode.interfaces;

import com.saints.gamecode.Position;

public interface IEntity {

    void setPosition(float x, float y);

    Position getPosition();

    int getWidth();

    int getHeight();
}
