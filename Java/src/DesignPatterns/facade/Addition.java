package DesignPatterns.facade;

public class Addition implements Facade{

    @Override
    public void doOperation(int a, int b) {
        System.out.println("Addition of two numbers:: "+ (a+b));
    }
}
