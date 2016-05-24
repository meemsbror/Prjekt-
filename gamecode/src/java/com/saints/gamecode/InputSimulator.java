package com.saints.gamecode;

import com.saints.gamecode.Direction;
import com.saints.gamecode.interfaces.IKeyInput;

class InputSimulator implements IKeyInput {
    Direction currentKey = Direction.P1LEFT;

    @Override
    public boolean isKeyPressed(Direction direction) {
        return direction == currentKey;
    }

    public void setCurrentKey(Direction currentKey) {
        this.currentKey = currentKey;
    }
}
