package com.saints.gamecode;

import java.awt.event.KeyListener;

import com.saints.gamecode.dependencies.KeyInput;
import com.saints.gamecode.scenes.Arena;

public class DependenciesHelper {


    public static KeyListener getKeyListener(Arena arena){
        return new KeyInput(arena);

    }
}

