package DesignPatterns.Observer;

public class Hexa extends IObserver {

    public Hexa(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }


    @Override
    public void update() {
        System.out.println("State Changed: Hexa:  " + this.subject.getState());
    }
}
