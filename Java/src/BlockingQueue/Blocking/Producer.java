package BlockingQueue.Blocking;

import java.util.concurrent.BlockingQueue;



public class Producer implements Runnable {

    BlockingQueue<Integer> queue;

    public Producer(BlockingQueue queue){
        this.queue=queue;
    }

    @Override
    public void run(){

            for (int i = 0; i <10 ; i++) {
                try{
                    queue.put(i);
                    System.out.println("Value Inserted: "+i);
                    Thread.sleep(200);
                }catch (InterruptedException ex){

                }

            }

    }
}
