package src.com.interview.arrays;

public class MinimumElementInSortedRotatedArray {

    /**
     * Given an input sorted rotated array. Find the minimum element in the array
     * @param args
     */
    public static void main(String[] args) {
        int arr[] = {5, 6, 1, 2, 3, 4};
        int arr1[] = {1, 2, 3, 4};
        int arr2[] = {2, 1};
        System.out.println(findMin(arr));
        System.out.println(findMin(arr1));
        System.out.println(findMin(arr2));

        System.out.println(findMinimum(arr,0,arr.length-1));
    }
    // Complexit is O(n)
    // As this is a binary sorted array we should try to solve it in O(log n)
    public static int findMin(int arr[]){
        int j = 0;
        int small = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[j]>arr[i])
                small= arr[i];

            j=i;
        }
        return small;
    }

    //Order of complexity O(log n)
    public static  int findMinimum(int arr[], int low, int high){
        // When the array is not rotated at all
        if(high < low)
            return arr[0];
        // When there is only one element left
        if(high == low)
            return low;
        int mid = low + (high - low)/2;
        // Check for cases where mid+1 is not the lowest then return mid+1
        if(mid < high && arr[mid+1]<arr[mid])
            return arr[mid+1];
        if(mid > low && arr[mid]<arr[mid-1])
            return arr[mid];
        if(arr[high] > arr[mid])
            return     findMinimum(arr,low,mid-1);
        return findMinimum(arr, mid+1,high);

    }
}
