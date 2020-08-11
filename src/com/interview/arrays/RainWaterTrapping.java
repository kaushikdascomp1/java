package src.com.interview.arrays;

public class RainWaterTrapping {

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("MAx Area covered is:: " + maxAreaBrute(arr));

        int[] rainWater = {3, 0, 2, 0, 4};
        System.out.println(maxWater(rainWater));
        System.out.println(maxAreaBrute(rainWater));
    }

    //With O(n) solution
    public static int maxWater(int arr[]) {

        int n = arr.length;

        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(arr[i], left[i - 1]);
        }
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(left[i], right[i]) - arr[i];
        }

        return res;
    }

    //Also to find the maximum Area that the container will cover:
    //https://www.gohired.in/2019/10/29/leetcode-container-with-most-water/

    public static int maxAreaBrute(int[] heights){
        if(heights.length <= 1)
            return 0;
        int maxARea = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            for(int j=i+1;j<heights.length;j++){
                maxARea = Math.max(maxARea,Math.min(heights[i],heights[j])*(j-i));
            }
        }
        return maxARea;
    }

    //Using Two pointer technique solving in O(n)
    public static int maxAreaTwoPOinterTechnique(int[] heights){
        if(heights.length<=1)
            return 0;
        int i=0;
        int j=heights.length-1;
        int maxArea =Integer.MIN_VALUE;
        while (i<j){
            maxArea = Math.max(maxArea,Math.min(heights[i],heights[j])*(j-i));
            if(heights[i]<=heights[j])
                i++;
            else
                j--;
        }

        return maxArea;
    }

}
