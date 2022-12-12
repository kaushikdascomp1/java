package com.interview.java.designpatterns.multithreaded.foobaralt;

public class FooBarMain {

    public static void main(String[] args) {
        FooBar fooBar =new FooBar(3);
        FooBarThread fooBarThread = new FooBarThread(fooBar, "foo");
        FooBarThread fooBarThread1 = new FooBarThread(fooBar, "bar");

        fooBarThread.start();
        fooBarThread1.start();
    }
}
