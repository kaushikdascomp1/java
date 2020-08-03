package src.com.interview.dp.UnboundedKnapsack;

public class MinimumCoinChange {

    /**
     * Given a target sum and a set of changes which you can take as many number of times
     * Find the minimum number of changes required to reach the target sum
     * @param args
     */


    public static void main(String[] args) {
        int targetSum = 5;
        int denom[] = {1,2,3};
        System.out.println(minimumChange(targetSum,denom,0));
    }

    public static int minimumChange(int targetSum, int denom[], int currentIndex){
        if(targetSum == 0)
            return 0;
        if(denom.length == 0 || currentIndex >= denom.length)
            return Integer.MAX_VALUE;
        int sum1 = Integer.MAX_VALUE;
        if(denom[currentIndex] <= targetSum){
            int res = minimumChange(targetSum-denom[currentIndex],denom,currentIndex);
            if(res != Integer.MAX_VALUE){
                sum1 = res+1;
            }
        }

        int sum2 = minimumChange(targetSum,denom,currentIndex+1);
        return Math.min(sum1,sum2);
    }


}
