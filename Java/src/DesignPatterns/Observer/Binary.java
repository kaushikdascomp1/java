package Java.src.DesignPatterns.Observer;

public class Binary extends IObserver {

    public Binary(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("State Changed: Binary:  "+ subject.getState());
    }
}
