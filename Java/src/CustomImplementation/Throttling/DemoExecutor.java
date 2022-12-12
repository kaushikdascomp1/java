package CustomImplementation.Throttling;

import java.util.concurrent.*;

/**
 * This class shows aan example of rejected execution handler example when intial pool size is full executing
 * the tasks, it moves to maxcorepool size. Even then the blockingqueue is filled
 * It adds the tasks again after waiting for a specified time using the rejectedexecutionhandler
 *
 */
public class DemoExecutor {


    public static void main(String[] args) {
        Integer threadCounter = 0;
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(50);
        CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(10,20,5000, TimeUnit.SECONDS,queue);
        executor.setRejectedExecutionHandler((Runnable r,ThreadPoolExecutor e)->{
            System.out.println("Demo Task Rejected::   "+((DemoTask) r).getName());
            try {
                Thread.sleep(1000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            //To execute the task again or using another executor service
            executor.execute(r);
            System.out.println("Adding another::  "+((DemoTask) r).getName());
        });
        //Starting all core threads initially
        executor.prestartAllCoreThreads();
        while(true){
            threadCounter++;
            //Adding tasks one by one
            executor.execute(new DemoTask(threadCounter.toString()));
            if (threadCounter == 200)
                break;
        }
        executor.shutdown();

    }
}
