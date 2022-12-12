package com.interview.java.designpatterns.multithreaded.orderedprinting;

public class OrderedPrintingThread extends Thread{

    OrderedPrinting orderedPrinting;
    String method;

    public OrderedPrintingThread(OrderedPrinting orderedPrinting, String method){
        this.orderedPrinting = orderedPrinting;
        this.method = method;
    }

    @Override
    public void run() {
        if("first".equalsIgnoreCase(method)){
            orderedPrinting.printFirst();
        } else if ("second".equalsIgnoreCase(method)) {
            try {
                orderedPrinting.printSecond();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else if ("third".equalsIgnoreCase(method)) {
            try {
                orderedPrinting.printThird();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
