package com.saints.gamecode.dependencies;

import com.saints.gamecode.Arena;
import com.saints.gamecode.Direction;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {


    Arena arena;
    Direction direction;

    public KeyInput (Arena arena){
        this.arena = arena;
    }

    @Override
    public void keyPressed(KeyEvent event){



        // Player 1 Movement
        switch(event.getKeyCode()){

            case KeyEvent.VK_A:
                direction = Direction.P1LEFT;
                break;
            case KeyEvent.VK_D:
                direction = Direction.P1RIGHT;
                break;
            case KeyEvent.VK_W:
                direction = Direction.P1JUMP;
                break;
            case KeyEvent.VK_S:
                direction = Direction.P1DIVE;
                break;

        //Player 2 Movement
            case KeyEvent.VK_LEFT:
                direction = Direction.P2LEFT;
                break;
            case KeyEvent.VK_RIGHT:
                direction = Direction.P2RIGHT;
                break;
            case KeyEvent.VK_UP:
                direction = Direction.P2JUMP;
                break;
            case KeyEvent.VK_DOWN:
                direction = Direction.P2DIVE;
                break;


        }
        arena.keyPressed(direction);

    }


    @Override
    public void keyReleased(KeyEvent event){
        arena.keyPressed(direction);
    }
}
