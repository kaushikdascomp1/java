package BlockingQueue.Blocking;


import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    java.util.concurrent.BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue queue){
        this.queue=queue;
    }

    @Override
    public void run() {
        while (true){
            try{
                System.out.println("Received Value: " + queue.take());
            }catch (InterruptedException ex){

            }

        }
    }
}
