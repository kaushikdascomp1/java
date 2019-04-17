package BlockingQueue;

public class BlockingQueueExample {

    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue(1);
       Thread t1 = new Thread(new ProducerRunner(queue));
       Thread t2 = new Thread(new ConsumerRunner(queue));
       t1.start();
       t2.start();
    }
}
