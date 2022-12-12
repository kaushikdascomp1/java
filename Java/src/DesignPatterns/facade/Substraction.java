package DesignPatterns.facade;

public class Substraction implements Facade{

    @Override
    public void doOperation(int a, int b) {
        System.out.println("Substraction of two numbers:: "+ (a-b));
    }
}
