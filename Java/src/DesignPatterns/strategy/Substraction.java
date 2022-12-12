package DesignPatterns.strategy;

public class Substraction implements Strategy {

    @Override
    public void doOperation(int a, int b) {
        System.out.println("Substraction of two numbers is ::  "+(a-b));
    }
}
