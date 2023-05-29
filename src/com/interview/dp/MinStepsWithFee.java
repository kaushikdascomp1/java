package com.interview.dp;

public class MinStepsWithFee {

    /*
    Given a staircase with ‘n’ steps and an array of ‘n’ numbers representing the fee that you have to pay if you take the step.
    Implement a method to calculate the minimum fee required to reach the top of the staircase (beyond the top-most step).
    At every step, you have an option to take either 1 step, 2 steps, or 3 steps. You should assume that you are standing at the first step.
    Number of stairs (n) : 6
    Fee: {1,2,5,2,1,2}
    Output: 3
    Explanation: Starting from index '0', we can reach the top through: 0->3->top
    The total fee we have to pay will be (1+2).
     */
    public static void main(String[] args) {
        int[] fee = {1,2,5,2,1,2};
        System.out.println(minFee(fee, 0));
    }

    public static int minFee(int[] fee, int currentIndex){
        if(fee.length == 0 || currentIndex>=fee.length)
            return 0;
        int step1 = minFee(fee, currentIndex+1);
        int step2 = minFee(fee, currentIndex+2);
        int step3 = minFee(fee, currentIndex+3);

        int min = Math.min(Math.min(step1, step2), step3);
        return min + fee[currentIndex];
    }

    public int minFeeDp(int[] fee, int currentIndex, Integer[] dp){
        if(fee.length == 0 || currentIndex >= fee.length)
            return 0;
        if(dp[currentIndex] != null)
            return dp[currentIndex];
        int step1 = minFeeDp(fee,currentIndex+1, dp);
        int step2 = minFeeDp(fee,currentIndex+2, dp);
        int step3 = minFeeDp(fee,currentIndex+3,dp);

        int min = Math.min(Math.min(step1, step2), step3);
        dp[currentIndex] = min + fee[currentIndex];
        return dp[currentIndex];
    }


}
