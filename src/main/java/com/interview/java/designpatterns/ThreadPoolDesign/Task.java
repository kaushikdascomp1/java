package com.interview.java.designpatterns.ThreadPoolDesign;

public class Task implements Runnable {

    int num;

    public Task(int num){
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("Executing task:: "+num);
    }
}
