package com.saints.gamecode.controllers.scenes;

import com.saints.gamecode.interfaces.IScene;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class Scene implements IScene{

    private final PropertyChangeSupport pcs;

    public Scene(){
        pcs = new PropertyChangeSupport(this);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener){
        pcs.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener){
        pcs.removePropertyChangeListener(listener);
    }

    public void firePropertyChange(String s, Object object1, Object object2){
        pcs.firePropertyChange(s, object1, object2);
    }
}
