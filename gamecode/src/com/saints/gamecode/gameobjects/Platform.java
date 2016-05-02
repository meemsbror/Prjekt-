package com.saints.gamecode.gameobjects;

/**
 * Created by ludvig on 2016-05-02.
 */
public class Platform {
    private int xPosStart; // Straight line to build platform to stand on.
    private int xPosStop;  // Have to be arrayList/polygontåg if we want to make a
    private int yPos;      // platform more complex than a line.

    public void setPos(int xPosStart, int xPosStop, int yPos){
        this.xPosStart = xPosStart;
        this.xPosStop = xPosStop;
        this.yPos = yPos;
    }

    public int getxPosStart() {
        return xPosStart;
    }

    public int getxPosStop() {
        return xPosStop;
    }

    public int getyPos() {
        return yPos;
    }
}
