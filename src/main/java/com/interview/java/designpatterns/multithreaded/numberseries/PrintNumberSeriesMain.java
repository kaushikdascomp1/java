package com.interview.java.designpatterns.multithreaded.numberseries;

public class PrintNumberSeriesMain {

    public static void main(String[] args) {
        PrintNumberSeries printNumberSeries = new PrintNumberSeries(5);

        PrintNumberSeriesThread zero = new PrintNumberSeriesThread(printNumberSeries, "zero");
        PrintNumberSeriesThread odd = new PrintNumberSeriesThread(printNumberSeries, "odd");
        PrintNumberSeriesThread even = new PrintNumberSeriesThread(printNumberSeries, "even");

        zero.start();
        odd.start();
        even.start();
    }
}
