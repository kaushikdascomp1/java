package DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    List<IObserver> observers = new ArrayList<>();
    int state;

    public int getState(){
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllOBservers();
    }

    public void notifyAllOBservers(){
        for(IObserver obs:observers)
            obs.update();
    }

    public void attach(IObserver observer){
        this.observers.add(observer);
    }
}
