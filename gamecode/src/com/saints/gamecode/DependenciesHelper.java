package com.saints.gamecode;

import java.awt.event.KeyListener;
import com.saints.gamecode.Arena;
import com.saints.gamecode.dependencies.KeyInput;

public class DependenciesHelper {


    public static KeyListener getKeyListener(Arena arena){
        return new KeyInput(arena);

    }

}
