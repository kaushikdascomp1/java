package src.com.interview.arrays;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindSubArrayToGivenSum {

    /**
     * Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number.
     *
     * @param args
     */

    public static void main(String[] args) {
        int arr[] = {1, 4, 20, 3, 10, 5};
        int sum = 33;
        subArraySum(arr,sum);

    }
    // Simple with complexity of O(n2)
    public static void subArraySum(int arr[], int sum){
        int starIndex = 0;
        int endIndex = 0;
        for(int i=0;i<arr.length;i++){
            int curr_sum = arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(curr_sum == sum){
                    endIndex = j-1;
                    starIndex = i;
                    System.out.println("Sub Array Sum is from Index: "+starIndex +" till " +endIndex);
                }
                if(curr_sum > sum || j==arr.length)
                    break;
                curr_sum +=arr[j];
            }
        }
        for(int k=starIndex; k<=endIndex;k++){
            System.out.println("Elements are: "+arr[k]);
        }
    }


}
