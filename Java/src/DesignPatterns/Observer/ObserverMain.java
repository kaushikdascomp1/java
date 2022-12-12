package DesignPatterns.Observer;

public class ObserverMain {

    public static void main(String[] args) {
        Subject subject = new Subject();
        Binary bin = new Binary(subject);
        Hexa hex = new Hexa(subject);
        Octal octa = new Octal(subject);

        subject.setState(14);
        subject.setState(15);
    }
}
