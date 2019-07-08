package src.com.interview.arrays;

public class CreatingDynamicArray {

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

}
