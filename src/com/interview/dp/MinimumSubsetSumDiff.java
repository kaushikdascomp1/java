package src.com.interview.dp;

import java.util.Arrays;

public class MinimumSubsetSumDiff {

    /*
        Given a set of positive numbers, partition the set into two subsets with a minimum difference between
        their subset sums
        int[] num = {1, 2, 3, 9};
        Following are the two subsets: {1, 2, 3} & {9}.
     */

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 9};
        //Should return the output as 3 which is the difference
        System.out.println(minimumSum(num));

        System.out.println(minimumSumDp(num));
    }

    public static int minimumSum(int num[]){
        return canPartitionRecursive(num,0,0,0);
    }

    private static int canPartitionRecursive(int num[], int sum1, int sum2, int currentIndex){
        if(num.length == currentIndex)
            return Math.abs(sum1-sum2);

        int diff1 = canPartitionRecursive(num,sum1+num[currentIndex],sum2,currentIndex+1);
        int diff2 = canPartitionRecursive(num,sum1,sum2+num[currentIndex],currentIndex+1);

        return Math.min(diff1,diff2);

    }

    //memoization solution
    private static int minimumSumDp(int num[]){
        int sum = Arrays.stream(num).sum();
        Integer dp[][] = new Integer[num.length][sum+1];
        return canPartitionDp(num,0,0,0,dp);
    }

    private static int canPartitionDp(int num[], int sum1, int sum2, int currentIndex, Integer dp[][]){
        if(num.length == currentIndex)
            return Math.abs(sum1-sum2);
        //You can use any one of the sum to calculate
        if(dp[currentIndex][sum1] != null)
            return dp[currentIndex][sum1];

        int diff1 = canPartitionDp(num,sum1+num[currentIndex],sum2,currentIndex+1,dp);
        int diff2 = canPartitionDp(num,sum1,sum2+num[currentIndex],currentIndex+1,dp);
        dp[currentIndex][sum1] = Math.min(diff1,diff2);

        return dp[currentIndex][sum1];
    }
}
