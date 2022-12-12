package com.interview.java.designpatterns.insertdelsearchrandds;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxFreqStack {

    /*
    Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
     */
    //Freq map contains val, freq
    Map<Integer, Integer> freqMap;
    //StackMap contins frequency of elements and stack
    Map<Integer, Stack<Integer>> stackMap;
    //Keeps track of the maxFreq
    int maxFreq;

    public MaxFreqStack(){
        this.freqMap = new HashMap<>();
        this.stackMap = new HashMap<>();
        this.maxFreq = 0;
    }

    public void push(int item){
        int cFreq = freqMap.getOrDefault(item, 0);
        cFreq++;
        freqMap.put(item, cFreq);
        if(!stackMap.containsKey(cFreq)){
            stackMap.put(cFreq, new Stack<>());
        }
        stackMap.get(cFreq).push(item);
        maxFreq = Math.max(maxFreq, cFreq);
    }

    public int pop(){
        int ans = stackMap.get(maxFreq).pop();
        int cFreq = freqMap.get(ans);
        cFreq--;
        freqMap.put(ans, cFreq);
        if(stackMap.get(maxFreq).size() == 0){
            maxFreq--;
        }
        return ans;
    }

}
