package src.com.interview.arrays;

import java.util.Scanner;

public class MaximumSubArraySum {

    public static void main(String args[]){
       int arr[] = new int[]{1, 2, 3, -2, 5};
        maxSum(arr);
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

}
