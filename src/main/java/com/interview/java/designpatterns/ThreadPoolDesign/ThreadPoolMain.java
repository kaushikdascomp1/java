package com.interview.java.designpatterns.ThreadPoolDesign;

public class ThreadPoolMain {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(5);
        for(int i=0;i<5;i++){
            Task task = new Task(i);
            threadPool.execute(task);
        }
    }
}
