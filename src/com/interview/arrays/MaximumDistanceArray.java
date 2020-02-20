package src.com.interview.arrays;

public class MaximumDistanceArray {

    //Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
    //
    //If there is no solution possible, return -1.
    public static void main(String[] args) {
     int A[] = {3,5,4,2};
        System.out.println(maxDistance(A));
    }

    public static int maxDistance(int[] arr){
            int curr_max = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>=arr[i]){
                    curr_max = j-i;
                }
                max = Math.max(curr_max,max);
            }
        }
        if(max == Integer.MIN_VALUE)
            max = -1;
        return max;
    }
}
