package DesignPatterns.Observer;

public abstract class IObserver {

    public Subject subject;
    public abstract void update();
}
