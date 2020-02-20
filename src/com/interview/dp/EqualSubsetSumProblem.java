package src.com.interview.dp;

import java.util.Arrays;

public class EqualSubsetSumProblem {

    //Given a integer array
    //Partition problem is to determine whether a given set can be partitioned into
    // two subsets such that the sum of elements in both subsets is same.
    //https://www.geeksforgeeks.org/partition-problem-dp-18/

    public static void main(String[] args) {

    }

    public static boolean canPartition(int[] num){
        int sum = Arrays.stream(num).sum();

        if(sum % 2 != 0)
            return false;
        else
            return canPartitionRecursive(num,sum/2,num.length);

    }

    private static boolean canPartitionGK(int[] num, int sum, int n){
        if(sum == 0)
            return true;
        if(n == 0 || sum !=0)
            return false;
        if(num[n-1]>sum)
            return canPartitionGK(num,sum,n-1);

        return (canPartitionGK(num,sum,n-1) || canPartitionGK(num,sum-num[n-1],n-1));
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

}
