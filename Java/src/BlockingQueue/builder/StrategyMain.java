package BlockingQueue.builder;

public class StrategyMain {

    public static void main(String[] args) {
        Strategy additionStrategy = new AdditionStrategy();
        Strategy substraction = new SubstractionStrategy();
        Context context = new Context(additionStrategy);

        context.execute(3,4);

        Context context1 = new Context(substraction);
        context1.execute(4,3);
    }
}
