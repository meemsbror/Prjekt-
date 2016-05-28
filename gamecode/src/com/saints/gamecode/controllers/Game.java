package com.saints.gamecode.controllers;

import com.saints.gamecode.interfaces.IGraphics;
import com.saints.gamecode.interfaces.IKeyInput;
import com.saints.gamecode.interfaces.IScene;
import com.saints.gamecode.controllers.scenes.Arena;
import com.saints.gamecode.controllers.scenes.CharacterSelectController;
import com.saints.gamecode.controllers.scenes.EndGameScene;
import com.saints.gamecode.controllers.scenes.MapSelectController;

    import java.beans.PropertyChangeEvent;
    import java.beans.PropertyChangeListener;


    public class Game implements PropertyChangeListener{

        //Saves the graphics and input so that it can create new scenes
        final private IGraphics graphics;
        final private IKeyInput input;

        //The currently selected scene that will update
        private IScene currentScene;

        //The arena scene
        private Arena arena;
        private CharacterSelectController csc;
        private MapSelectController msc;
	    private EndGameScene endGameScene;

        public Game(IKeyInput input, IGraphics graphics){
            this.graphics = graphics;
            this.input = input;
            this.arena = new Arena(input, graphics);
            this.csc = new CharacterSelectController(input, graphics);
	        this.endGameScene = new EndGameScene(graphics);
            this.msc = new MapSelectController(input, graphics);
            csc.addPropertyChangeListener(this);
            arena.addPropertyChangeListener(this);
            msc.addPropertyChangeListener(this);
	        endGameScene.addPropertyChangeListener(this);
            this.currentScene = this.csc;
        }

        public void update(float delta) {
            currentScene.update(delta);
        }

        public void propertyChange(PropertyChangeEvent event){
            //Checks if it the Characters that are selected and switches scene to arena
            if(event.getSource() instanceof CharacterSelectController){
                this.arena.setCharacters(csc.getPlayer1(), csc.getPlayer2());
                this.currentScene = this.msc;
            }else if (event.getSource() instanceof MapSelectController) {
                this.arena.setMap(msc.getMap());
                this.currentScene = arena;
            }else if (event.getSource() instanceof Arena){
	            this.endGameScene.setWinnerPicture(event.getPropertyName());
                this.currentScene = this.endGameScene;
            }else if (event.getSource() instanceof EndGameScene){
	            this.currentScene = csc;
            }
        }
    }
