package com.saints.gamecode.interfaces;

import java.beans.PropertyChangeListener;

public interface IScene {

    public void update(float delta);

    void addPropertyChangeListener(PropertyChangeListener listener);

    void removePropertyChangeListener(PropertyChangeListener listener);
}
