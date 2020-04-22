package src.com.interview.Numbers;

import scala.Int;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LongestConsequtiveSubsequence {
    /**
     * https://www.geeksforgeeks.org/longest-consecutive-subsequence/
     * Given an array of integers, find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
     * @param args
     *
     * Input: arr[] = {1, 9, 3, 10, 4, 20, 2}
     * Output: 4
     * The subsequence 1, 3, 4, 2 is the longest subsequence
     * of consecutive elements
     */

    public static void main(String[] args) {
        int[] arr = {2,6,1,9,4,5,3};
        subsequence(arr);
    }
        //Put all elements in a hashset and then try to find the starting element by checking arr[i]-1 exists then update
    public static void subsequence(int arr[]){
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<arr.length;i++)
            set.add(arr[i]);
        int startVal = arr[0];

        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i]-1)){
                startVal = Math.min(arr[i]-1,startVal);
            }
        }


        System.out.println("Start Val:: "+startVal);
        int count = 1;
        //Once you find the starting point check in the set till startval+1 exists and increment count
        for(int i=0;i<arr.length;i++){
            if (set.contains(startVal + 1)) {
                count++;
                startVal++;
            }
        }

        System.out.println(count);



    }

}
