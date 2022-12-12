package com.interview.java.designpatterns.multithreaded.numberseries;

public class PrintNumberSeriesThread extends Thread{

    PrintNumberSeries numberSeries;
    String method;

    public PrintNumberSeriesThread(PrintNumberSeries numberSeries, String method){
        this.numberSeries = numberSeries;
        this.method = method;
    }

    @Override
    public void run() {
        if("zero".equalsIgnoreCase(method)){
            try {
                numberSeries.printZero();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if("odd".equalsIgnoreCase(method)){
            try {
                numberSeries.printOdd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if("even".equalsIgnoreCase(method)){
            try {
                numberSeries.printEven();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
