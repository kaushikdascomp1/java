package src.com.interview.arrays;

public class RainWaterTrapping {

    public static void main(String[] args) {

    }

    //With O(n) solution
    public int maxWater(int arr[]){

        int n = arr.length;

        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = arr[0];
        for (int i = 1; i < n ; i++) {
            left[i] = Math.max(arr[i],left[i-1]);
        }
        right[n-1] = arr[n-1];
        for (int i = n-2; i >=0 ; i--) {
            right[i] = Math.max(arr[i],right[i+1]);
        }
        int res = 0;
        for (int i=0;i<n;i++){
            res += Math.min(left[i],right[i])-arr[i];
        }

    return res;
    }
}
