package BlockingQueue;

public class ProducerRunner implements Runnable {

    BlockingQueue queue;
    boolean isEven;
    int count;

    public ProducerRunner(BlockingQueue queue){
        this.queue=queue;

    }

    @Override
    public void run() {
       for(int i=0;i<10;i++){
           try {
               queue.put(i);
               System.out.println("Inserted:"+i);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }



}
