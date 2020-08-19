package com.interview.java.designpatterns.stackqueue;

public class StackQueueMain {

    public static void main(String[] args) {
        GenericQueue<Integer> queue = new GenericQueue<>(4);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

}
