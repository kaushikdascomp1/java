package Java.src.Java8.CompletableFuture;

import java.util.function.Consumer;

public class InnerClass {
    /*
        Types of Anonymous Inner classes
     */
    public static void main(String[] args) {
        //Types of Anonymous Inner classes
        //1.Anonymous inner class extending class
        Thread th = new Thread(){
            @Override
            public void run() {
                System.out.println("Child Thread Running");
            }
        };
        th.start();
        System.out.println("Main Thread Running");

        //2. Anonymous Inner class Using Interface
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Child Thread 2 Running");
            }
        };
        Thread th2 = new Thread(runnable);
        th2.start();
        System.out.println("Main Thread 2 Running");

        //3. Using Runnable inside constructor

        Thread th3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Child Thread 3");
            }
        });
        System.out.println("Main Thread 3 Running");
        th3.start();

        // 4. This can be replaced with lambda

        Thread th4 = new Thread(()->{
            System.out.println("Child Thread 4 running");
        });

        th4.start();
        System.out.println("Main Thread 4 running");
    }
}
