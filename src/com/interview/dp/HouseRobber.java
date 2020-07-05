package src.com.interview.dp;

public class HouseRobber {

    /*
    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them
    is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
    Input: [1,2,3,1]
    Output: 4
    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
    Total amount you can rob = 1 + 3 = 4.

    This will fail test case :
    arr[] = {2,1,1,2}
     */

    public static void main(String[] args) {
        int arr[] = {1,2,3,1};
        System.out.println(maxAmt(arr));

        int arr2[] = {2,7,9,3,1};
        System.out.println(maxAmt(arr2));

        int arr3[] = {2,1,1,2};
        System.out.println(recursiveMax(arr3,arr3.length-1));

       int dp[] = new int[arr3.length];
        System.out.println(memoizationApproach(arr3,arr3.length-1, dp));

        int dp2[] = new int[arr2.length];
        System.out.println(memoizationApproach(arr2,arr2.length-1, dp2));
    }


    public static int maxAmt(int arr[]){
        int curr_max1 = 0;
        for(int i=0;i<arr.length;i+=2){
            curr_max1 += arr[i];
        }
        int curr_max2 = 0;
        for(int i=1;i<arr.length;i+=2){
            curr_max2 += arr[i];
        }
        return Math.max(curr_max1,curr_max2);
    }

    //Where i is length of the array
    public static int recursiveMax(int arr[],int i){
        if(i<0)
            return 0;
        //Knapsack, you have two options, either you rob the current house or leave it
        //If you rob the current house, you need to rob next the i-2 house,
        //If you don't rob it then you can rob the i-1 house
        return Math.max(recursiveMax(arr,i-2)+arr[i],recursiveMax(arr,i-1));
    }

    public static int memoizationApproach(int arr[], int i, int dp[]){
        if(i<0)
            return 0;
        if (dp[i]!=0)
            return dp[i];
        dp[i] =  Math.max(memoizationApproach(arr,i-2,dp)+arr[i],memoizationApproach(arr,i-1,dp));
        return dp[i];
    }
}
