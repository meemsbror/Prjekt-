package com.saints.gamecode.dependencies;

import java.awt.event.KeyListener;
import com.saints.gamecode.Arena;

public class DependenciesHelper {


    public static KeyListener getKeyListener(Arena arena){
        return new KeyInput(arena);
    }
}
