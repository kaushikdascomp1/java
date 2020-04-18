package src.com.interview.Queue;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class StringFrequencySort {

    /**
     * Given a string, sort it based on the decreasing frequency of its characters.
     * @param args
     */

    public static void main(String[] args) {
        String input = "Programming";
        decreasingFrequency(input);
        //output: rrggmmPaino
        countFrequency(input);
        //output: rrggmmPiano
    }
    //Using priorityQueue maxheap to solve it in O(Nlogn)
    //Usually it is O(D*log D) where D is the number of distinct characters but in the worst case scenario, it is O(Nlog N)

    public static void countFrequency(String string){
        StringBuilder stringBuilder = new StringBuilder();
        Map<Character,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((e1,e2)->e2.getValue()-e1.getValue());
        char[] charArr = string.toCharArray();

        for(int i=0;i<charArr.length;i++)
            map.put(charArr[i],map.getOrDefault(charArr[i],0)+1);
        maxHeap.addAll(map.entrySet());

        while (!maxHeap.isEmpty()){
            Map.Entry<Character,Integer> entry = maxHeap.poll();
            for (int i=0;i<entry.getValue();i++){
                stringBuilder.append(entry.getKey());
            }

        }

        System.out.println(stringBuilder.toString());

    }

    //Time complexity increased to O(n2)
    public static void decreasingFrequency(String string){
        StringBuilder stringBuilder = new StringBuilder();
        Map<Character,Integer> map = new HashMap<>();
        char[] charArr = string.toCharArray();
        for (Character val:charArr)
            map.put(val,map.getOrDefault(val,0)+1);
        LinkedHashMap<Character, Integer> sortedMapByValue = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        for(Map.Entry<Character, Integer> entry:sortedMapByValue.entrySet()){
           for(int i=0;i<entry.getValue();i++)
               stringBuilder.append(entry.getKey());
        }
        System.out.println(stringBuilder.toString());

    }
}
