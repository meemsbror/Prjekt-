package com.saints.gamecode.interfaces;

import com.saints.gamecode.utils.Vector2D;
import com.saints.gamecode.Entities.gameobjects.GameObject;
import com.saints.gamecode.Entities.gameobjects.Platform;

public interface IPhysics {

    Vector2D getGravity(float delta);

    boolean hasCollided (GameObject object1, GameObject object2);
    boolean isStandingOnPlatform(GameObject object, Platform platform);
    boolean isOutsidePlatform(GameObject gameObject, Platform platform, GameObject gameObject2);

}
