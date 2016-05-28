package Entities.gameobjects;

import com.saints.gamecode.Position;
import Entities.gameobjects.characters.SmurfCharacter;
import org.junit.Test;

public class GameObjectTest {


    private final GameObject gameObject = new SmurfCharacter(true);

    @Test
    public void move() throws Exception {

        float x1 = random();
        float y1 = random();
        float x2 = random();
        float y2 = random();

        gameObject.setPosition(0,0);
        gameObject.move(x1, y1);
        gameObject.move(x2, y2);

        assert gameObject.getOldPos().getX() == x1;
        assert gameObject.getOldPos().getY() == y1;

        assert gameObject.getPos().getX() == x1 + x2;
        assert gameObject.getPos().getY() == y1 + y2;
    }

    @Test
    public void revertHorizontalPosition() throws Exception {

        gameObject.move(random(),random());

        Position oldPos = gameObject.getOldPos();
        Position newPos = gameObject.getPos();


        assert newPos.getX() != oldPos.getX();

        gameObject.revertHorizontalPosition();

        newPos = gameObject.getPos();

        assert newPos.getX() == oldPos.getX();
    }

    @Test
    public void revertVerticalPosition() throws Exception {
        gameObject.move(random(),random());

        Position oldPos = gameObject.getOldPos();
        Position newPos = gameObject.getPos();


        assert newPos.getY() != oldPos.getY();

        gameObject.revertVerticalPosition();

        newPos = gameObject.getPos();

        assert newPos.getY() == oldPos.getY();

    }

    private float random(){
        return (float)Math.random();
    }
}