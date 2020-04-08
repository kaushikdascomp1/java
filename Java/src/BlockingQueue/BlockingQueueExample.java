package Java.src.BlockingQueue;
import java.util.stream.IntStream;

public class BlockingQueueExample {

    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue(1);

       Thread producerThread = new Thread(()->{
          try{
              for(int i=0;i<10;i++){
                  queue.put(i);
                  System.out.println("Item Added:: "+i);
              }

          }catch (InterruptedException ex){
              ex.printStackTrace();
          }

       });
       producerThread.start();

       Thread consumerThread = new Thread(()->{
           try{
               while(queue.cap != 0){
                   int item = queue.get();
                   System.out.println("Received Item:: "+item);
               }

           }catch (InterruptedException ex){
               ex.printStackTrace();
           }

       });
       consumerThread.start();
    }
}
