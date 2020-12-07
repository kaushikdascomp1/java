package Java.src.DesignPatterns.strategy;

public class StrategyMain {

    public static void main(String[] args) {
        Strategy strategy = new Addition();
        Context additionContext = new Context(new Addition());
        additionContext.execute(2,3);

        Context subsContext = new Context(new Substraction());
        subsContext.execute(3,2);
    }
}
