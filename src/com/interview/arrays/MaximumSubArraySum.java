package src.com.interview.arrays;

import java.util.Scanner;

public class MaximumSubArraySum {

    //Also called as Kadane's Algorithm
    //https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
    //Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
    public static void main(String args[]){
       int arr[] = new int[]{1, 2, 3, -2, 5};
       int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        maxSum(arr);
        maxSum(a);
        maximumSumKadane(arr);
        maximumSumKadane(a);
        //o/p
        //Maximum Subarray Sum, Kadane: 9
        //Maximum Subarray Sum, Kadane: 7
    }

    public static void maxSum(int arr[]){
        int sum=0;
        int currMax;
        for(int i=0;i<arr.length;i++){
            sum +=arr[i];
            currMax = Math.max(arr[i],sum);
            if (currMax < sum) {
                currMax=sum;
            }
        }
        System.out.println(sum);
    }

    public static void maximumSumKadane(int arr[]){
        int max_so_far = 0;
        int curr_max = 0;
        for(int i=0;i<arr.length;i++){
            curr_max = Math.max(arr[i],curr_max+arr[i]);
            max_so_far = Math.max(curr_max,max_so_far);
        }

        System.out.println("Maximum Subarray Sum, Kadane: "+ max_so_far);

    }

}
