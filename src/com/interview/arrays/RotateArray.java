package src.com.interview.arrays;

public class RotateArray {

    /**
     * To rotate an array leftwise or rightwise
     * https://www.geeksforgeeks.org/array-rotation/
     * Time Complexity O(n*d) where d is the number of places to shift
     * @param args
     */

    public static void main(String args[]){
        int arr[] = new int[]{1,2,3,4,5};
        printArray(arr);
        leftRotate(arr,2);
        printArray(arr);
    }

    public static void leftRotate(int arr[], int d){

        for(int i=0;i<d;i++){
            leftRotateByOne(arr,arr.length);
        }
    }

    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void leftRotateByOne(int arr[], int n){
        int temp = arr[0];
        for(int i=0;i<n-1;i++){
            arr[i]=arr[i+1];
            arr[i+1]=temp;
        }
    }

    private static void rightRotateByOne(int arr[], int n){
        int temp = arr[0];
        for(int i=0;i<n;i++){
            arr[i+1] = arr[i];
            arr[i]=temp;
        }
    }

}
