package src.com.interview.Queue;

import java.util.PriorityQueue;

public class kthSmallestStream {

/**
 * To find the kth smallest number on a stream
 * If you add new number also, it should keep the elements and return the smallest
 *
 */
        public static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1,n2)->n2-n1);
        int k;

        public static void main(String[] args) {
            kthSmallestStream stream = new kthSmallestStream();
            int[] nums = new int[] { 6, 1, 5, 12, 2, 11 };
            stream.kSmallestStream(nums,3);
            System.out.println("2nd Smallest current: "+maxHeap.peek());
            stream.add(4);
            System.out.println("2nd Smallest current: "+maxHeap.peek());
        }

        public void kSmallestStream(int[] nums, int k){
           this.k = k;
            if(nums.length<k)
                System.out.println("Element size should be greater than k::  ");
            else {
                for(int i=0;i<nums.length;i++){
                    add(nums[i]);
                }
            }

        }

        public int add(int num){
            maxHeap.add(num);
            if(maxHeap.size()>this.k){
                maxHeap.poll();
            }

            return maxHeap.peek();
        }

}
