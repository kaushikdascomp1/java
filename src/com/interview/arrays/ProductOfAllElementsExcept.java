package arrays;

import java.util.Arrays;

public class ProductOfAllElementsExcept {

    /*
    You are given an array of integers. Return an array of the same size where the element at each index is the product of all the elements in the original array except for the element at that index.
    For example, an input of [1, 2, 3, 4, 5] should return [120, 60, 40, 30, 24].
    You cannot use division in this problem.
     */
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        findProduct(arr);
    }

    private static void findProduct(int arr[]){
        int n = arr.length;

        int prod = 1;
        int left[] = new int[n];
        for(int i=0;i<n;i++){
            left[i] = prod;
            prod *=arr[i];
        }

        prod = 1;
        int right[] = new int[n];
        for (int i=n-1;i>=0;i--){
            right[i] = prod;
            prod *=arr[i];
        }
       // System.out.println("Left Subarray is:  "+Arrays.toString(left));
       // System.out.println("Right Subarray is:  "+Arrays.toString(right));
        for (int i=0;i<n;i++){
           arr[i] = left[i]*right[i];
        }

        System.out.println(Arrays.toString(arr));
    }

}
