package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxFreqStack {

    /*
    In a stream of elemensts coming into a system, when you need to find the count of each elements is fine where
    you need only a map but for keeping a track of maxFrequency stack where with 1 freq we can have the elements with entire stack
     */

    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> stackMap;
    int maxFreq;

    public MaxFreqStack(){
        freqMap = new HashMap<>();
        stackMap = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val){
        int cFreq = freqMap.getOrDefault(val, 0);
        cFreq++;
       freqMap.put(val, cFreq);
       if(!stackMap.containsKey(cFreq)){
           stackMap.put(cFreq, new Stack<>());
       }
       stackMap.get(cFreq).push(val);
       maxFreq = Math.max(maxFreq, cFreq);
    }

    public int pop(){
        int ans = stackMap.get(maxFreq).pop();
        int cfreq = freqMap.get(ans);
        cfreq--;
        freqMap.put(ans, cfreq);
        if(stackMap.get(maxFreq).size() == 0){
            maxFreq--;
        }
        return ans;
    }
}
