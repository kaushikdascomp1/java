package src.com.interview.arrays;

public class SmallestSubArrayWithGivenSum {

    //Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
    // Return 0, if no such subarray exists.
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 3, 2};
        System.out.println(subArraySum(arr,7));
    }

    public static int subArraySum(int arr[], int S){
       int minLength = Integer.MAX_VALUE;
       int winStart = 0;
       int winSum = 0;
       for(int winEnd=0;winEnd<arr.length;winEnd++){
           winSum+=arr[winEnd];
           while(winSum >= S){
               minLength = Math.min(minLength,winEnd-winStart+1);
               winSum -=arr[winStart];
               winStart++;
           }
       }

       return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }


}
