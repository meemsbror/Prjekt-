package com.saints.gamecode;

/**
 * Created by Axel on 16/04/19.
 */
public final class HealthBar {

    private int currentMax;
    private int divider;

    /*
    We use the singleton design pattern in order to make sure that we can
    only have a single Health-Bar at any time
     */
    private static volatile HealthBar instance;
    private HealthBar() { }

    public static HealthBar getInstance() {
        if (instance == null ) {
            synchronized (HealthBar.class) {
                if (instance == null) {
                    instance = new HealthBar();
                }
            }
        }

        return instance;
    }



    // Method for setting the current HP bar's max
    public void setMax(int x){
        this.currentMax += x;
    }

    // returns
    public int getMax(){
        return currentMax;
    }



}
