package com.saints.gamecode;

import com.saints.gamecode.gameobjects.characters.Character;
import com.saints.gamecode.gameobjects.items.Platform;
import com.saints.gamecode.interfaces.IGraphics;
import com.saints.gamecode.interfaces.IKeyInput;
import com.saints.gamecode.interfaces.IScene;
import com.saints.gamecode.maps.SandboxMap;
import com.saints.gamecode.maps.UmpMap;
import com.saints.gamecode.scenes.Arena;
import com.saints.gamecode.scenes.CharacterSelectController;
import com.saints.gamecode.scenes.EndGameScene;
import com.saints.gamecode.scenes.MapSelectController;

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
            csc.addPropertyChangeListener(this);
            arena.addPropertyChangeListener(this);
	        endGameScene.addPropertyChangeListener(this);
            this.currentScene = this.csc;
        }

        public void update(float delta) {
            currentScene.update(delta);
        }

        public void propertyChange(PropertyChangeEvent event){
            //Checks if it the Characters that are selected and switches scene to arena
            if(event.getSource() instanceof CharacterSelectController){
                //Todo add mapSelecter and send in that map instead of SandBoxMap
                this.arena.setMap(new UmpMap());
                this.arena.setCharacters(csc.getPlayer1(), csc.getPlayer2());
                this.currentScene = this.arena;
            }else if (event.getSource() instanceof Arena){
	            this.endGameScene.setWinnerPicture(event.getPropertyName());
                this.currentScene = this.endGameScene;
            }else if (event.getSource() instanceof EndGameScene){
	            System.out.println("jaaa");
	            this.currentScene = csc;
            }
        }
    }
