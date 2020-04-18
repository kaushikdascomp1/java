package src.com.interview.Queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    /**
     *
     * To find the kth largest numbers
     *  For Largest Numbers use minHeap and for smallest numbers use max heap
     * In a stream of numbers always the smallest
     *
     */

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] nums = new int[] { 3, 1, 5, 12, 2, 11 };
        int k=3;
        List<Integer> kLargest = kthLargest(nums, minHeap, k);
        System.out.println("Set of largest Numbers are::  ");
        kLargest.stream().forEach(System.out::println);

    }

    public static List<Integer> kthLargest(int[] arr, PriorityQueue<Integer> queue, int k){
        for (int i=0;i<k;i++){
            queue.add(arr[i]);
        }
        // Going through the remaining elements of the queue
        //The list will contain the top k largest element
        // if nums[i] < queue.peek, we skip it because it is already smallest and we
        // IN the queue at a time only k elements will remain
        System.out.println(queue);
        for (int i = k; i < arr.length; i++) {
            if(arr[i] > queue.peek()){
                queue.poll();
                queue.add(arr[i]);
            }
        }

        return new ArrayList<>(queue);
    }
}
