package com.interview.java.designpatterns.stackqueue;

import java.util.Stack;

public class QueueUsingStacks {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public QueueUsingStacks(){
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    void push(int item){
        if(s1.isEmpty()){
            s1.push(item);
        }else {
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(item);
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
    }

    int poll(){
        if(!s1.isEmpty()){
            return -1;
        }else {
            return s1.pop();
        }
    }

    int peek(){
        if(!s1.isEmpty()){
            return -1;
        }else {
            return s1.peek();
        }
    }
}
