package DesignPatterns.strategy;

public class Context {

    Strategy strategy;

    public Context(Strategy strategy){
        this.strategy =strategy;
    }

    public void execute(int a, int b){
        this.strategy.doOperation(a,b);
    }
}
