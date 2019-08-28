package src.com.interview.Searching;

public class BinarySearchSortedRotated {

    public static void main(String args[]){
        int arr[] = new int[]{3,4,5,1,2};
        int key = binarySearch(arr,arr.length,2);
        System.out.println(key);
    }

    public static int binarySearch(int arr[],int n, int key){

        int pivot = findPivot(arr,0,n-1);
        if(pivot == -1)
            binarySear(arr,0,n-1,key);
        if(arr[pivot]==key)
            return arr[pivot];
        if(arr[0]<=key)
           binarySear(arr,0,pivot-1,key);
        return binarySear(arr,pivot+1,n-1,key);
    }

    public static int binarySear(int arr[],int low, int high,int key){
        int mid = (low+high)/2;
        if(arr[mid]==key)
            return arr[mid];
        if(key>arr[mid])
            return binarySear(arr,mid+1,high,key);
       return binarySear(arr,low,mid-1,key);
    }

    public static int findPivot(int arr[], int low, int high){

        int mid = low+high/2;
        if(high<low)
            return -1;
        if(high == low)
            return low;
        //Check if mid+1 isn't the pivot
        //{3,4,5,1,2} this case where mid+1 is the pivot
        if(mid < high && arr[mid+1] < arr[mid])
            return mid+1;
        // Check if mid isn't the pivot
        if(mid > low && arr[mid] < arr[mid-1])
            return mid;
        if(arr[low] > arr[mid])
            return findPivot(arr,low,mid-1);
        return findPivot(arr,mid+1,high);
    }
}
