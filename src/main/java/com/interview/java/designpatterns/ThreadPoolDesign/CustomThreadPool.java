package com.interview.java.designpatterns.ThreadPoolDesign;

import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {

    private int nThreads;
    private LinkedBlockingQueue<Runnable> queue;
    private PoolWorker[] threads;

    public CustomThreadPool(int th){
        this.nThreads = th;
        this.queue = new LinkedBlockingQueue<>();
        threads = new PoolWorker[th];

        for(int i=0;i<th;i++){
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }


    private class PoolWorker extends Thread{

        @Override
        public void run() {
            Runnable task;
            while (true){
                 synchronized (queue){
                     while (queue.isEmpty()){
                         try{
                             this.wait();
                         }catch (InterruptedException ex){
                             ex.printStackTrace();
                         }

                     }

                     task = queue.poll();

                 }
                 try {
                     task.run();
                 }catch (RuntimeException ex){
                     System.out.println("Thread pool interrupted:: "+ex.getStackTrace());
                 }
            }
        }
    }
}
