package com.interview.java.designpatterns.insertdelsearchrandds;

import java.util.Stack;

public class StackMin {

    /*
    Design a stack that supports getMin() in O(1) time and O(1) extra space
     Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack.
     All these operations of SpecialStack must be O(1). To implement SpecialStack, you should only use standard Stack data structure and no other data structure like arrays, list etc
     */

    public Stack<Node> stack;

    public StackMin(){
        this.stack = new Stack<>();
    }

    public static void main(String[] args) {

    }

    class Node{
        int val;
        int min;
        public Node(int val, int min){
            this.val = val;
            this.min = min;
        }
    }

    public void push(int val){
        if(stack.isEmpty()){
            stack.push(new Node(val, val));
        }else {
            int min = Math.min(stack.peek().min, val);
            stack.push(new Node(val, min));
        }
    }

    public int peek(){
        return stack.peek().val;
    }

    public int pop(){
        return stack.pop().val;
    }

    public int getMin(){
        return stack.peek().min;
    }
}
