package src.com.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WaveArray {

    //Given an unsorted array of integers, sort the array into a wave like array.
    // An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..

    public static void main(String[] args) {
        int arr[] = {10, 90, 49, 2, 1, 5, 23};
        int result[] = sortArray(arr);
        Arrays.stream(result).forEach(System.out::println);

        int result1[] = sortArrayWithoutSorting(arr);
        Arrays.stream(result1).forEach(System.out::println);
    }

    public static int[] sortArray(int[] arr){
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i+=2){
                swap(arr,i,i+1);
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
        ArrayList<Integer> AB = new ArrayList<>();
    }

    public static int[] sortArrayWithoutSorting(int[] arr){
        for(int i=0;i<arr.length;i+=2){
            if(i>0 && arr[i-1]>arr[i])
                swap(arr,i-1,i);
            if(i<arr.length-1 && arr[i]<arr[i+1])
                swap(arr,i,i+1);
        }
        return arr;
    }
}
