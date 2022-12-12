package CustomImplementation.Throttling.RejectedTasksAfterExecutorshutdown;

import Java.src.CustomImplementation.CustomThreadPool.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedExecutionHandlerExample {

    public static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
    public static ThreadPoolExecutor alternateExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        executor.setRejectedExecutionHandler((Runnable r, ThreadPoolExecutor e) -> {
            System.out.println("Rejected Task is:  " + r.toString());
            try {
                Thread.sleep(1000);
                System.out.println("Submitting task to alternate executor:  " + r.toString());
                alternateExecutor.execute(r);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Rejected Task finished execution by alternate executor:  " + r.toString());
        });

        System.out.println("Starting ThreadPool Executor::  ");

        Java.src.CustomImplementation.Throttling.RejectedTasksAfterExecutorshutdown.Worker[] workers = new Java.src.CustomImplementation.Throttling.RejectedTasksAfterExecutorshutdown.Worker[10];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Java.src.CustomImplementation.Throttling.RejectedTasksAfterExecutorshutdown.Worker(i);
            executor.execute(workers[i]);
            //Shutdown executor after 6 th task to check if this is excuted by alternate executor
            if (i == 6)
                executor.shutdown();

        }

        // executor.shutdown();
        while (!executor.isTerminated())
            System.out.println("Waiting for executor to terminate::: ");

        System.out.println("Execution completed:: Executor service shut down complete::");
        alternateExecutor.shutdown();

        while (!alternateExecutor.isTerminated()) {

        }
        //  System.out.println("Waiting for alternate Executor to shutdown::  ");


        System.out.println("Execution completed:: Alternate Executor service shut down complete::");

    }


}
