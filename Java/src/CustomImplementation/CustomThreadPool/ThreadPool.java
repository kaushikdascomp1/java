package Java.src.CustomImplementation.CustomThreadPool;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

    public final int nThreads;
    public final LinkedBlockingQueue<Runnable> queue;
    public final PoolWorker[] threads;

    public ThreadPool(int nThreads){
        this.nThreads = nThreads;
        this.queue = new LinkedBlockingQueue();
        threads = new PoolWorker[nThreads];

        for(int i=0;i<nThreads;i++){
            threads[i] = new PoolWorker();
            threads[i].start();
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
        public void run(){
            Runnable task;
            while(true){
                synchronized (queue){
                    while (queue.isEmpty()){
                        try{
                            queue.wait();
                        }catch (InterruptedException ex){
                            System.out.println("Error Occurred while processing elements:  ");
                        }
                    }
                    task = queue.poll();
                }

                try{
                    task.run();
                }catch (RuntimeException ex){
                    System.out.println("Thread pool interrupted::  " + ex.getStackTrace());
                }
            }

        }

    }

}
