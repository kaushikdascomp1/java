package com.interview.java.designpatterns.multithreaded.foobaralt;

import lombok.SneakyThrows;

public class FooBarThread extends Thread{

    FooBar fooBar;
    String method;

    public FooBarThread(FooBar fooBar, String method){
        this.fooBar = fooBar;
        this.method = method;
    }

    @SneakyThrows
    @Override
    public void run() {
        if("foo".equalsIgnoreCase(method)){
            fooBar.printFoo();
        }
        if("bar".equalsIgnoreCase(method)){
            fooBar.printBar();
        }
    }
}
