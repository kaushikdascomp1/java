package src.com.interview.dp;

public class KnapsackBest {

    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int capacity = 7;
        int maxKnapsackProfit = knapsack(weights, profits, capacity, 0);
        System.out.println(maxKnapsackProfit);

        Integer[][] dp = new Integer[profits.length][capacity+1];
        int knapsackmemo = knapsackmemo(profits, weights, capacity, 0, dp);
        System.out.println(knapsackmemo);
    }

    //recursive solution O(2^n) with overlapping sub problems
    public static int knapsack(int[] weights, int[] profits, int capacity, int currentIndex){
        if(capacity <=0 || currentIndex>=profits.length)
            return 0;
        //either include or exclude it
        int profit1 = 0;
        //including the element
        if(weights[currentIndex]<=capacity)
            profit1 = profits[currentIndex] + knapsack(weights,profits,capacity-weights[currentIndex],currentIndex+1);
        //excluding the item
        int profit2 = knapsack(weights,profits,capacity,currentIndex+1);
        return Math.max(profit1,profit2);
    }

    //Top Down approach using memoization
    public static int knapsackmemo(int[] weights,int[] profits, int capacity,int currentIndex,Integer[][] dp){
        if(capacity <= 0 || currentIndex>=profits.length)
            return 0;

        if(dp[currentIndex][capacity] != null)
            return dp[currentIndex][capacity];
        //including it
        int profit1 = 0;
        if(weights[currentIndex]<=capacity)
            profit1 = profits[currentIndex]+knapsackmemo(weights,profits,capacity-weights[currentIndex],currentIndex+1,dp);

        //excluding the item(currentIndex which is profits so skipping the profitIndex)
        int profits2 = knapsackmemo(weights,profits,capacity,currentIndex+1,dp);

        //setting the valur again to the dp table
        dp[currentIndex][capacity] = Math.max(profit1,profits2);
        return dp[currentIndex][capacity];
    }

}
