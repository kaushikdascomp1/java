package com.interview.java.designpatterns.ThreadPoolDesign;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

    private int nThreads;
    LinkedBlockingQueue<Runnable> queue;
    private PoolWorker[] poolWorker;

    public ThreadPool(int nThreads){
        this.nThreads = nThreads;
        this.queue = new LinkedBlockingQueue<>();
        poolWorker = new PoolWorker[nThreads];

        for(int i=0;i<nThreads;i++){
            poolWorker[i] = new PoolWorker();
            poolWorker[i].start();
        }
    }

    public void execute(Runnable task){
        synchronized (queue){
            queue.add(task);
            queue.notify();
        }
    }


    private class PoolWorker extends Thread{

        @Override
        public void run() {
            while (true){
                Runnable task;
                synchronized (queue){
                    while(queue.isEmpty()){
                        try{
                            queue.wait();
                        }catch (InterruptedException ex){
                            System.out.println("Error Occurred while processing elements:  ");
                        }
                    }

                    task = queue.poll();
                    try{
                        task.run();
                    }catch (RuntimeException ex){
                        System.out.println("Thread pool interrupted::  " + ex.getStackTrace());
                    }
                }
            }
        }
    }
}
