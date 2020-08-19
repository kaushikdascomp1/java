package com.interview.java.designpatterns.stackqueue;

public class GenericStack<T> {

    public int maxSize;
    public int currSize;
    public T[] array;
    public int top;

    public GenericStack(int maxSize){
        this.maxSize = maxSize;
        //Current Size is just for reference, how many elements are there in the stack, For user perspective and not from programmatic point of view
        this.currSize = 0;
        this.array = (T[]) new Object[maxSize];
        this.top = -1;
    }

    public int getCurrSize(){
        return this.currSize;
    }

    public void push(T item){
        if(top == maxSize-1)
            System.out.println("Stack is full");
        else {
            array[++top] = item;
            currSize++;
        }
    }

    public T pop(){
        T item = null;
        if(top == -1)
            return item;
        else {
            item = array[top--];
            currSize--;
            return item;
        }
    }

    public T peek(){
        T item = null;
        if(top == -1)
            return item;
        else {
            item = array[top];
        }

        return item;
    }

}
