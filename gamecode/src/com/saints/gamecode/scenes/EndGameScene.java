package com.saints.gamecode.scenes;

import com.saints.gamecode.Background;
import com.saints.gamecode.interfaces.IGraphics;

public class EndGameScene extends Scene {
	private final IGraphics graphics;
	float time;
	private Background player1Win = new Background("assets/pictures/player1Wins");
	private Background player2Win = new Background("assets/pictures/player2Wins");
	private Background winnerPicture;

	public EndGameScene(IGraphics graphics){
		this.graphics = graphics;

	}

	public void setWinnerPicture(String winner){
		if (winner.equals("Player 1")){
			this.winnerPicture = player1Win;
		}else if (winner.equals("Player 2")){
			this.winnerPicture = player2Win;
		}else{
			throw new IllegalArgumentException("No such player");
		}
		graphics.addTexture(winnerPicture.getImgPath());
		graphics.finishLoading();
	}


	@Override
	public void update(float delta) {
		time += delta;
		if (time > 5){
			time = 0;
			firePropertyChange("new game",null,null);
		}else {
			graphics.update(winnerPicture);
		}
	}
}
