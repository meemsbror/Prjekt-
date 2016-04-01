package com.saints.gamecode.dependencies;

import com.saints.gamecode.Arena;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {


    Arena arena;

    public KeyInput (Arena arena){
        this.arena = arena;
    }

    @Override
    public void keyPressed(KeyEvent event){
        arena.keyPressed(event.getKeyCode());
    }


    @Override
    public void keyReleased(KeyEvent event){
        arena.keyPressed(event.getKeyCode());
    }
}
