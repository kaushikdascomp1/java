package GSCoderPad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class MedianOfTwoArrays {

    public static void main(String[] args) {
        int arr1[] = {2,3,4,5};
        int arr2[] = {6,7,8,9} ;
        median(arr1,arr2);

       int[] arr3 = MergeSort.mergeSort(arr1,arr1.length,arr2,arr2.length,new int[arr1.length+arr2.length]);
        Arrays.stream(arr3).forEach(item->{
            System.out.println(item);
        });
        int n3 = arr3.length;
        if(n3%2 != 0){
            System.out.println("Median of Odd is: "+ arr3[n3/2]);
        }else {
            System.out.println("Median of Even is: "+ (arr3[(n3-1)/2]+arr3[n3/2])/2);
        }
    }

    public static void median(int arr1[], int arr2[]){
        List<Integer> list1 = new ArrayList<Integer>();
        list1.addAll(Arrays.stream(arr1).boxed().collect(Collectors.toList()));
        list1.addAll(Arrays.stream(arr2).boxed().collect(Collectors.toList()));
        System.out.println(list1);

    }

}
