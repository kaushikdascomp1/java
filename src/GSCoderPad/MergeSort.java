package src.GSCoderPad;

import java.util.Arrays;

public class MergeSort {



    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int n1 = arr1.length;

        int[] arr2 = {2, 4, 6, 8};
        int n2 = arr2.length;
        int[] arr3 = new int[n1+n2];
        mergeSort(arr1,n1,arr2,n2,arr3);
        Arrays.stream(arr3).forEach(item->{
            System.out.println(item);
        });
    }

    public static int[] mergeSort(int arr1[], int n1, int arr2[], int n2, int arr3[]){
        int i=0,j=0,k=0;
        while(i<n1 && j<n2){
            if(arr1[i]<arr2[j]){
                //Store and increment
                arr3[k++] = arr1[i++];
            }else{
                arr3[k++] = arr2[j++];
            }
        }
        //Store remaining left out elements from arr1 and arr2
        while(i<n1)
            arr3[k++] = arr1[i++];

        while (j<n2)
            arr3[k++] = arr2[j++];
        return arr3;
    }


}
