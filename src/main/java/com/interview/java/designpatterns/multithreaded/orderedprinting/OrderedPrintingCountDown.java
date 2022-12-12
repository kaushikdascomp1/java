package com.interview.java.designpatterns.multithreaded.orderedprinting;

import java.util.concurrent.CountDownLatch;

public class OrderedPrintingCountDown {

    CountDownLatch latch1;
    CountDownLatch latch2;

    public OrderedPrintingCountDown(){
        this.latch1 = new CountDownLatch(1);
        this.latch2 = new CountDownLatch(2);
    }

    public void printFirst(){
        System.out.println("First");
        latch1.countDown();
    }

    public void printSecond() throws InterruptedException {
        //Check if latch1 is finished
        latch1.await();
        System.out.println("Second");
        latch2.countDown();
    }

    public void printThrid() throws InterruptedException {
        latch2.await();
        System.out.println("Third");
    }

}
