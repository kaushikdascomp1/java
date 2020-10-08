package src.com.interview.arrays;

public class MaxmumSubArrayOfSizeK {

    /**
     *
     * Maximum Subarray of Size k
     * Ex: 1 2 3 1 4 5 2 3 6
     * K=3
     * o/p :3 3 4 5 5 5 6
     */
    public static void main(String args[]){
        int arr[] = new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6};
        subArray(arr,3);
        minMaxSubarray(arr,3);
    }

        public static void subArray(int arr[], int k){
            for(int i=0;i<=arr.length-k;i++){
                int max=arr[i];
                    for(int j=1;j<k;j++){
                        if(arr[i+j]>max){
                            max=arr[i+j];
                        }
                    }
                System.out.println("Max: "+max);
             }
        }

        public static void minMaxSubarray(int[] arr, int k){
            for (int i = 0; i <= arr.length-k; i++) {
                int max = arr[i];
                int min = arr[i];
                for (int j=1;j<k;j++){
                    max = Math.max(max,arr[i+j]);
                    min = Math.min(min,arr[i+j]);
                }
                System.out.print("Max is:  "+max);
                System.out.print("  Min is:  "+min);
            }
        }
}
