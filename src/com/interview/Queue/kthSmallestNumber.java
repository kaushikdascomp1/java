package src.com.interview.Queue;

import java.util.PriorityQueue;

public class kthSmallestNumber {

    /**
     *
     * To find the kth smallest numbers
     *  For Largest Numbers use minHeap and for smallest numbers use max heap
     * In a set of numbers always the smallest
     *
     */
    public static void main(String[] args) {
        int[] nums = new int[] { 3, 1, 5, 12, 2, 11 };
        int k=3;
        kthSmallestNumbers(nums,k);
    }

    public static void kthSmallestNumbers(int[] nums, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1,n2)->n2-n1);
        if(nums.length<k)
            System.out.println("Input size is smaller than k:  ");
        else {
            for(int i=0;i<k;i++){
                maxHeap.add(nums[i]);
            }
            // Going through the remaining elements of the queue
            //The list will contain the top k smallest element
            //
            for(int i=k;i<nums.length;i++){
                if(nums[i]<maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.add(nums[i]);
                }
            }
        }

        System.out.println("kth Smallest Number is: "+maxHeap.poll());


    }
}
