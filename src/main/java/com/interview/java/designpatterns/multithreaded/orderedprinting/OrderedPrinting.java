package com.interview.java.designpatterns.multithreaded.orderedprinting;

public class OrderedPrinting {

    public int count;

    public OrderedPrinting(){
        this.count = 1;
    }

    public void printFirst(){
        synchronized (this){
            System.out.println("First");
            count++;
            notifyAll();
        }
    }

    public void printSecond() throws InterruptedException {
        synchronized (this){
            while (count != 2){
                this.wait();
            }
            System.out.println("Second");
            count++;
            notifyAll();
        }
    }

    public void printThird() throws InterruptedException {
        synchronized (this){
            while (count != 3){
                this.wait();
            }
            System.out.println("Third");
            count++;
            notifyAll();
        }
    }
}
