package BlockingQueue.Blocking;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueEx {

    public static void main(String[] args) {
        BlockingQueue<Integer> shared = new LinkedBlockingQueue<Integer>();
        Thread t1 = new Thread(new Producer(shared));
        Thread t2 = new Thread(new Consumer(shared));
        t1.start();
        t2.start();

    }
}
