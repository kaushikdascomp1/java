package BlockingQueue;

public class ConsumerRunner implements Runnable {

    BlockingQueue queue;

    public ConsumerRunner(BlockingQueue queue){
        this.queue=queue;
    }

    @Override
    public void run(){
        try{
            int val = queue.get();
            System.out.println("Received: "+val);
        }catch (InterruptedException ev){

        }

    }
}
