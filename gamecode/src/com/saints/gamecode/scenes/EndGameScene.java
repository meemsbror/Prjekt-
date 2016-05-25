package com.saints.gamecode.scenes;

import com.saints.gamecode.Background;
import com.saints.gamecode.HealthBar;
import com.saints.gamecode.interfaces.IGraphics;
import org.lwjgl.Sys;

import java.util.Timer;

public class EndGameScene extends Scene {
	private String winner;
	private final IGraphics graphics;
	float time;
	Background background1 = new Background("assets/pictures/player 1 wins");
	Background background2 = new Background("assets/pictures/player 2 wins");

	public EndGameScene(String winner, IGraphics graphics){
		this.graphics = graphics;
		setWinner(winner);
		graphics.addTexture(background1.getImgPath());
		graphics.addTexture(background2.getImgPath());

	}

	private void setWinner(String winner){
		if (winner.equals("Player 1")){
			this.winner = winner;
		}if (winner.equals("Player 2")){
			this.winner = winner;
		}else{
			this.winner = "Lars";
		}
	}


	@Override
	public void update(float delta) {
		time += delta;
		if (time > 5){
			time = 0;
			firePropertyChange("new game",null,null);
		}else if (HealthBar.getInstance().getWinner().equals("Player 1")){ // when 5 seconds have pass draw getWinner
			graphics.update(background1);

		}else if (HealthBar.getInstance().getWinner().equals("Player 2")){ // -''-
			graphics.update(background2);
		}
	}
}
