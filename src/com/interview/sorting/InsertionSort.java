package src.com.interview.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6 };
        int arr1[] = { 2, 3, 4, 1, 5 };
        int arr2[] = { 4,3,1,2 };
        printArr(arr);
        sortArr(arr);
        printArr(arr);

        sortArr(arr1);
        sortArr(arr2);
    }


    private static void sortArr(int arr[]){
        int count = 0;
        for(int i=1;i<arr.length;i++){
            int key = arr[i];
            int j = i-1;

            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j=j-1;
                count++;
            }
            arr[j+1] = key;
        }
        System.out.println("Total Swaps: "+count);
    }

    private static void printArr(int arr[]){
        Arrays.stream(arr).forEach(System.out::println);
    }
}
