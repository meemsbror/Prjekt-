package com.saints.gamecode.Entities;

import com.saints.gamecode.AnimationObject;
import org.junit.Test;

/**
 * Created by frej on 5/28/16.
 */
public class PauseMenuTest {
    private PauseMenu pauseMenu = new PauseMenu(new AnimationObject("asdf",2,2,2));

    @Test
    public void setPaused() throws Exception {

        pauseMenu.setPaused(true,0.4f);
        pauseMenu.setPaused(false,0.2f);
        assert pauseMenu.isPaused();

        pauseMenu.setPaused(false,0.2f);

        assert !pauseMenu.isPaused();

    }

    @Test
    public void forcePaused() throws Exception {

        pauseMenu.forcePaused(true);

        assert pauseMenu.isPaused();

        pauseMenu.forcePaused(false);

        assert !pauseMenu.isPaused();

    }

}