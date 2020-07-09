package src.com.interview.dp;

import java.util.Arrays;

public class EqualSubsetSumProblem {

    //Given a integer array
    //Partition problem is to determine whether a given set can be partitioned into
    // two subsets such that the sum of elements in both subsets is same.
    //https://www.geeksforgeeks.org/partition-problem-dp-18/

    //This is similar to Subset sum problem, If you can find the subset sum of Half of the array
    //The pther half should be of similar sum

    public static void main(String[] args) {
        int num[] = {1,2,3,4};
        //Should return True
        System.out.println(canPartition(num));;

        int num1[] = {1,2,4};
        //SHould return false
        System.out.println(canPartition(num1));

        //Checking the same solution using recursive DP
        System.out.println("DP Memoization Technique:: "+canParttitionRecursiveDP(num));
        //Should return false using memoization DP
        System.out.println("DP Memoization Technique:: "+canParttitionRecursiveDP(num1));
    }

    public static boolean canPartition(int[] num){
        int sum = Arrays.stream(num).sum();

        if(sum % 2 != 0)
            return false;
        else
            return canPartitionRecursive(num,sum/2,0);

    }

    //Groking pattern
    private static boolean canPartitionRecursive(int[] num, int sum, int currentIndex){
        if(sum == 0)
            return true;
        if(num.length == 0 || currentIndex >= num.length)
            return false;
        //either include it or exclude it
        if(num[currentIndex] <= sum){
            if(canPartitionRecursive(num,sum-num[currentIndex],currentIndex+1))
                return true;
        }
        //Recursive call to exclude the item
        return canPartitionRecursive(num,sum,currentIndex+1);
    }

   //recursive solution using memoization

   private static boolean canParttitionRecursiveDP(int num[]){
        int sum = Arrays.stream(num).sum();

        if(sum % 2 != 0)
            return false;
        else {
            Boolean dp[][] = new Boolean[num.length][sum/2+1];
            return canPartitionDP(num,sum/2,0,dp);
        }
   }

   private static boolean canPartitionDP(int num[], int sum, int currentIndex, Boolean dp[][]){
        if (sum == 0)
            return true;
        if(num.length == 0 || currentIndex>=num.length)
            return false;
        if(dp[currentIndex][sum] != null){
            return dp[currentIndex][sum];
        }

        if(num[currentIndex]<= sum){
            if(canPartitionDP(num,sum-num[currentIndex],currentIndex+1,dp)){
                dp[currentIndex][sum] = true;
                return true;
            }

        }

       dp[currentIndex][sum] = canPartitionDP(num, sum, currentIndex + 1, dp);
       return dp[currentIndex][sum];
   }

}
