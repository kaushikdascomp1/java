package src.com.interview.arrays;

public class SlidingWindowSubArraySum {

    public static void main(String[] args) {
        int[] arr = {2,1,5,1,3,2};
        int k=3;
        System.out.println(subArraySum(arr,k));
    }

    public static int subArraySum(int[] arr, int k){
        int max = arr[0];
        for(int i=0;i<arr.length-k;i++){
            int sum = arr[i];
            for (int j = 1; j < k ; j++) {
                sum+=arr[i+j];
            }
            if(sum>max)
                max=sum;
        }
        return max;
    }
}
