package DesignPatterns.strategy;

public class Addition implements Strategy {

    @Override
    public void doOperation(int a, int b) {
        System.out.println("Addition of two numbers::  "+(a+b));
    }
}
