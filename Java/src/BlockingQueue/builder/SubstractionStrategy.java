package BlockingQueue.builder;

public class SubstractionStrategy implements Strategy{

    @Override
    public void doOperation(int a, int b) {
        System.out.println("Substraction of two numbers:: "+(a-b));
    }
}
