package com.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithSmallestSum {

    /*
    Given two lists and an integer k, find k pairs of numbers with the smallest sum so that in each pair,
    each list contributes one number to the pair.
     */
    public static void main(String[] args) {

    }

    static class KPair{
        int sum;
        int i;
        int j;

        public KPair(int sum, int i, int j){
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    /*
    1. Pop the smallest elemnt from the minHeap and add it to the result list noting the sum of each pair as i and j
    2. Increment j to move forward in the second list
    3. If there are more items in the second list add list1[i]+list2[j] all elements in j for each element in i
    Increment j to move forward in the second list, and compose a new pair with the same element from the first list and the
    next element in the second list. This step is skipped if a new pair can’t be formed when the popped pair’s j was already pointing
    to the end of the second list.


     */
    public static List<List<Integer>> pairsWithSmallestSum(int[] list1, int[] list2, int k){
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<KPair> minHeap = new PriorityQueue<>((e1, e2)-> e1.sum - e2.sum);

        //Adding first element of second list to all elements of first list
        //list1 = {2,8,9}   list2={1,3,6}  --> [{1,2}=3,{1,8}=9, {1,9}=10]
        int listength = list1.length;
        for(int i=0;i<Math.min(k, listength);i++){
            minHeap.add(new KPair(list1[i]+list2[0], i, 0));
        }

        int counter=1;
        while (!minHeap.isEmpty() && counter<=k){
            KPair kPair = minHeap.poll();
            int i = kPair.i;
            int j = kPair.j;
            //add the pair to the result list
            result.add(Arrays.asList(list1[i], list2[j]));
            j = j+1;
            if(list2.length > j){
                minHeap.add(new KPair(list1[i]+list2[j], i, j));
            }
            counter++;
        }
        return result;
    }
}
