package com.saints.gamecode.interfaces;

import com.saints.gamecode.Vector2D;
import com.saints.gamecode.gameobjects.GameObject;

public interface IPhysics {

    Vector2D getGravity(float delta);

    boolean hasCollided (GameObject object1, GameObject object2);

}
