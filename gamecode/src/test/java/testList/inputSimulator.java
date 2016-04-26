package test.java.testList;

import com.saints.gamecode.Direction;
import com.saints.gamecode.interfaces.IKeyInput;

/**
 * Created by admin on 2016-04-25.
 */
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
