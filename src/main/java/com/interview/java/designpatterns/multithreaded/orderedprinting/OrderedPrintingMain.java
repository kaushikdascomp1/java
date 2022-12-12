package com.interview.java.designpatterns.multithreaded.orderedprinting;

public class OrderedPrintingMain {

    public static void main(String[] args) {
        OrderedPrinting obj = new OrderedPrinting();

        OrderedPrintingThread th1 = new OrderedPrintingThread(obj, "first");
        OrderedPrintingThread th2 = new OrderedPrintingThread(obj, "second");
        OrderedPrintingThread th3 = new OrderedPrintingThread(obj, "third");

        th1.start();
        th3.start();
        th2.start();
    }
}
