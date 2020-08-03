package src.com.interview.dp.UnboundedKnapsack;

public class CoinChange {

    //Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
    // how many ways can we make the change? The order of coins doesn’t matter.

    public static void main(String[] args) {
        int[] denominations = {1, 2, 3};
        System.out.println(coinChangeRecursive(denominations, 5));
    }

    public static int coinChange(int[] S, int m, int n){
        // If n is 0 then there is 1 solution
        // (do not include any coin)
        if(n == 0)
            return 1;
        // If n is less than 0 then no
        // solution exists
        if(n<0)
            return 0;
        // If there are no coins and n
        // is greater than 0, then no
        // solution exist
        if(m<=0 && n>0){
            return 1;
        }
        // count is sum of solutions (i)
        // including S[m-1] (ii) excluding S[m-1]
        return coinChange(S,m-1,n)+coinChange(S,m,n-S[m-1]);
    }

    public static int coinChangeRecursive(int[] denominations, int total){
        return coinChangeRecursive(denominations,total,0);
    }

    public static int coinChangeRecursive(int[] denominations, int total, int currentIndex){
        if(total == 0)
            return 1;
        if(denominations.length == 0 || currentIndex >= denominations.length)
            return 0;
        // Either we select it or we don't select it
        // recursive call after selecting the coin at the currentIndex
        // if the coin at currentIndex exceeds the total, we shouldn't process this
        int sum1 = 0;
        if(denominations[currentIndex] <= total){
            sum1 = coinChangeRecursive(denominations,total-denominations[currentIndex],currentIndex);

        }
        //// recursive call after excluding the coin at the currentIndex
        int sum2 = coinChangeRecursive(denominations,total,currentIndex+1);
        return sum1+sum2;
    }

    public static int countChange(int[] denominations, int total)
    {
        Integer[][] dp = new Integer[denominations.length][total + 1];
        return countChangeRecursive(dp, denominations, total, 0);
    }

    private static int countChangeRecursive(Integer[][] dp, int[] denominations, int total, int currentIndex)
    {
        // base checks
        if (total == 0)
            return 1;

        if(denominations.length == 0 || currentIndex >= denominations.length)
            return 0;

        // if we have already processed a similar sub-problem, return the result from memory
        if(dp[currentIndex][total] != null)
            return dp[currentIndex][total];

        // recursive call after selecting the coin at the currentIndex
        // if the number at currentIndex exceeds the total, we shouldn't process this
        int sum1 = 0;
        if( denominations[currentIndex] <= total )
            sum1 = countChangeRecursive(dp, denominations, total - denominations[currentIndex], currentIndex);

        // recursive call after excluding the number at the currentIndex
        int sum2 = countChangeRecursive(dp, denominations, total, currentIndex + 1);

        dp[currentIndex][total] = sum1 + sum2;
        return dp[currentIndex][total];
    }


}
