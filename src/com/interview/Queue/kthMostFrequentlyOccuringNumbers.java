package src.com.interview.Queue;

import java.util.*;

public class kthMostFrequentlyOccuringNumbers {

    /**
     * Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.
     * Input: [1, 3, 5, 12, 11, 12, 11], K = 2
     * Output: [12, 11]     *
     */

    public static void main(String[] args) {
        int nums[] ={1, 3, 5, 12, 11, 12, 11};
        int k=2;
        kthFrequency(nums,2);

    }

    public static void kthFrequency(int[] nums, int k){
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n:nums)
            frequencyMap.put(n,frequencyMap.getOrDefault(n,0)+1);

        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((e1,e2)->e1.getValue()-e2.getValue());
        for(Map.Entry<Integer,Integer> numSet:frequencyMap.entrySet()){
            minHeap.add(numSet);
            if(minHeap.size()>k)
                minHeap.poll();
        }

        List<Integer> numList = new ArrayList<>();
       while (!minHeap.isEmpty())
            numList.add(minHeap.poll().getKey());

        numList.stream().forEach(System.out::println);
    }
}
