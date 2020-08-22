package src.com.interview.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {9,3,2,7,4,1,5,8};
        quickSort(arr,0,arr.length-1);
       Arrays.stream(arr).forEach(System.out::println);
    }

    public static void quickSort(int[] arr, int lo, int hi){
        if(arr.length <=0)
            return;
        if(lo>=hi)
            return;

        int mid = lo+(hi-lo)/2;
        int pivot = arr[mid];

        int i=lo;
        int j = hi;
        while (i<=j){
            while (arr[i]<pivot)
                i++;

            while (arr[j] > pivot)
                j--;

            if(i<=j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if(lo<j)
            quickSort(arr, lo, j);
        if(hi>i)
            quickSort(arr,i,hi);

    }
}
