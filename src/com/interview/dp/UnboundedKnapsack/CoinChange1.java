package src.com.interview.dp.UnboundedKnapsack;

public class CoinChange1 {

    /**
     * Given a target sum and an infinite number of coins, in how many ways you can make changes?
     * Suppose target sum  = 5
     * Coins = {1,2,3}
     * 5*1
     * 2*2+1
     * 3+2
     * 3+1+1
     * 2+1+1+1
     *
     * @param args
     */

    public static void main(String[] args) {
        int targetSum = 5;
        int denom[] = {1,2,3};
        System.out.println(howmanywayscoinchange(targetSum,denom,0));
        System.out.println(howmanywayscoinchangeDP(targetSum,denom,0));
    }

    public static int howmanywayscoinchange(int targetSum, int denom[], int currentIndex){
            //base case
        if(targetSum == 0)
            return 1;
        if(denom.length == 0 || currentIndex >= denom.length)
            return 0;

        int sum1 = 0;
        if(denom[currentIndex] <= targetSum){
            //include it then don't increment the current index as this is in how many ways, you can take any one denom n number of times
            sum1 = howmanywayscoinchange(targetSum - denom[currentIndex],denom,currentIndex);
        }

        int sum2 = howmanywayscoinchange(targetSum,denom,currentIndex+1);

        return sum1+sum2;
    }

    public static int howmanywayscoinchangeDP(int targetSum, int denom[], int currentIndex){
        Integer dp[][] = new Integer[denom.length+1][targetSum+1];
        return howmanywaysDP(targetSum,denom,currentIndex,dp);
    }

    public static int howmanywaysDP(int targetSum, int denom[], int currentIndex, Integer dp[][]){
        //base case
        if(targetSum == 0)
            return 1;
        // error handle case
        if(denom.length == 0 || currentIndex >= denom.length)
            return 0;
        //main case
        if(dp[currentIndex][targetSum] != null)
            return dp[currentIndex][targetSum];
        int sum1 = 0;
        if(denom[currentIndex] <= targetSum){
            sum1 = howmanywaysDP(targetSum-denom[currentIndex],denom,currentIndex,dp);
        }

        int sum2 = howmanywaysDP(targetSum, denom, currentIndex+1, dp);
        dp[currentIndex][targetSum] = sum1+sum2;
        return dp[currentIndex][targetSum];
    }
}
