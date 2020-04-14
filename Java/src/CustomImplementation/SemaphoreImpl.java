package Java.src.CustomImplementation;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreImpl {

    public static void main(String[] args) throws InterruptedException{
        sampleSemaphore();
    }

    public static void sampleSemaphore() throws InterruptedException{
        Semaphore semaphore = new Semaphore(1,true);

        Thread th1 = new Thread(()->{

                try{
                    semaphore.acquire();
                    System.out.println("Lock Acquired:  for Thread 1");
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }finally {
                    semaphore.release();
                    System.out.println("Lock Released:  for Thread 1");
                }

        });

        th1.start();

        Thread.sleep(2000);
        Thread th2 = new Thread(()->{

                try {
                    semaphore.acquire();
                    System.out.println("Lock Acquired:  for Thread 2");
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }finally {
                    semaphore.release();
                    System.out.println("Lock Released:  for Thread 2");
                }

        });

        th2.start();
        th1.join();
        th2.join();
        System.out.println("All programs executed:::");


    }
}
