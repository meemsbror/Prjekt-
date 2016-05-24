package com.saints.gamecode.scenes;

import com.saints.gamecode.interfaces.IGraphics;
import org.lwjgl.Sys;

import java.util.Timer;

public class EndGameScene extends Scene {
	private final long startTime;
	private String winner;
	private final IGraphics graphics;

	public EndGameScene(String winner, IGraphics graphics){
		this.startTime = System.currentTimeMillis();
		this.graphics = graphics;
		setWinner(winner);

	}

	private void setWinner(String winner){
		if (winner.equals("player 1")){
			this.winner = winner;
		}if (winner.equals("player 2")){
			this.winner = winner;
		}else{
			this.winner = "Lars";
		}
	}


	@Override
	public void update(float delta) {
		if (startTime + 5000 < System.currentTimeMillis()){
			firePropertyChange("new game",null,null);
		//}else if (getWinner().equals("player 1")){ // when 5 seconds have pass draw getWinner

		//}else if (getWinner().equals("player 2")){ // -''-

		}
	}
}
