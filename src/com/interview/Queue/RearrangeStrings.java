package Queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeStrings {

    /*
    Given a string, find if its letters can be rearranged in such a way that no two same characters come next to each other
    Input: "aappp"
    Output: "papap"
    Explanation: In "papap", none of the repeating characters come next to each other.
     */

    public static void main(String[] args) {

    }

    public void rearrange(String str){
        //base conditions
        Map<Character, Integer> map  = new HashMap<>();
        for(Character character:str.toCharArray()){
            map.put(character,map.getOrDefault(character, 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        maxHeap.addAll(map.entrySet());

        StringBuilder strb = new StringBuilder();
        Map.Entry<Character, Integer> previousEntry = null;
        while (!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            //adding the previous entry back to queue if frequency is greater than 0
            if(previousEntry != null && previousEntry.getValue()>0){
                maxHeap.offer(previousEntry);
            }
            strb.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            previousEntry = currentEntry;
        }

    }
}
