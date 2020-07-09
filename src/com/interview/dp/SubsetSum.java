package src.com.interview.dp;

import java.util.Arrays;

public class SubsetSum {

    /*
    Given a given set of numbers and a sum, determine whether any subset contains the sum
    Input: {1, 2, 7, 1, 5}, S=10
    Output: True


     */
    public static void main(String[] args) {
        //Should return true
        int num[] = {1, 2, 7, 1, 5};
        int expectedSum = 6;

        //should return true
        int num1[] = {1, 2, 3, 7};
        int expectedSum1 = 6;

        //should return false
        int num2[] = {1, 3, 4, 8};
        int expectedSum2 = 6;


        System.out.println(subsetSumDP(num,expectedSum));
        System.out.println(subsetSumDP(num1,expectedSum1));
        System.out.println(subsetSumDP(num2,expectedSum2));
    }

    public static boolean subsetSum(int num[], int sum){
        //considering only positive numbers
        if(num.length < 0 || sum < 0)
            return false;

        int arraySum = Arrays.stream(num).sum();
        if(arraySum<sum)
            return false;
       return subsetSumRecursive(num,sum,0);
    }

    public static boolean subsetSumRecursive(int num[], int sum, int currentIndex){
        if(sum == 0)
            return true;
        if(num.length == 0 || currentIndex >= num.length)
            return false;
        if(num[currentIndex]<=sum){
           if(subsetSumRecursive(num,sum-num[currentIndex],currentIndex+1))
               return true;
        }

        return subsetSumRecursive(num,sum,currentIndex+1);
    }


    //DP Memoization way
    public static boolean subsetSumDP(int num[], int sum){
        int totalSum = Arrays.stream(num).sum();
        if(totalSum < sum)
            return false;
        Boolean dp[][] = new Boolean[num.length][sum+1];
        return subsetSumRecursiveDP(num,sum,0,dp);
    }

    public static boolean subsetSumRecursiveDP(int num[], int sum, int currentIndex, Boolean dp[][]){
        if(sum == 0)
            return true;
        if(num.length<=0 || currentIndex>=num.length)
            return false;
        if(dp[currentIndex][sum] != null){
            return dp[currentIndex][sum];
        }
        if(num[currentIndex] <= sum)
            if(subsetSumRecursiveDP(num,sum-num[currentIndex],currentIndex+1,dp)){
                dp[currentIndex][sum] = true;
                return true;
            }
        dp[currentIndex][sum] = subsetSumRecursiveDP(num,sum,currentIndex+1,dp);
        return dp[currentIndex][sum];
    }
}
