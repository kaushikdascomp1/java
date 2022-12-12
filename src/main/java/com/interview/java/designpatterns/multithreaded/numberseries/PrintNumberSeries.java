package com.interview.java.designpatterns.multithreaded.numberseries;

import java.util.concurrent.Semaphore;

public class PrintNumberSeries {

    private int n;
    private Semaphore zeroSem;
    private Semaphore oddSem;
    private Semaphore evenSem;

    public PrintNumberSeries(int n){
        this.n = n;
        zeroSem = new Semaphore(1);
        oddSem = new Semaphore(0);
        evenSem = new Semaphore(0);
    }

    public void printZero() throws InterruptedException {
        for(int i=0;i<n;i++){
            zeroSem.acquire();
            System.out.println("0");
            (i%2 == 0 ? oddSem : evenSem).release();
        }
    }

    public void printOdd() throws InterruptedException {
        for(int i=1;i<=n;i+=2){
            oddSem.acquire();
            System.out.println(i);
            zeroSem.release();
        }
    }

    public void printEven() throws InterruptedException {
        for(int i=2;i<=n;i+=2){
            evenSem.acquire();
            System.out.println(i);
            zeroSem.release();
        }
    }
}
