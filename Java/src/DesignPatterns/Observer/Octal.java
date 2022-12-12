package DesignPatterns.Observer;

public class Octal extends IObserver {

    public Octal(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }


    @Override
    public void update() {
        System.out.println("State Changed: Octal: "+this.subject.getState());
    }
}
