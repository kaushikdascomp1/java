package com.interview.java.designpatterns.stackqueue;

public class GenericQueue<T> {

    public int maxSize;
    public int currSize;
    public T[] array;
    public int front;
    public int back;


    public GenericQueue(int maxSize){
        this.maxSize = maxSize;
        this.currSize = 0;
        this.front = 0;
        this.back = -1;
        this.array = (T[]) new Object[maxSize];
    }

    public int getTotalQueueSize(){
        return this.currSize;
    }

    public void add(T item){
        if(this.currSize == maxSize-1)
            System.out.println("Queue is full:: ");
        else {
            array[++back] = item;
            currSize++;
        }
    }

    public T poll(){
        T item = null;
        if(this.currSize == 0){
            System.out.println("Queue is empty::: ");

        }else {
            item = array[front++];
            currSize--;
        }
        return item;
    }

}
