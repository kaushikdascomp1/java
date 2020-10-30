package src.com.interview.dp;

public class CountOfStrings {

    /*
    Count of strings that can be formed using a,b and c under given constraints
    Given a length n, count the number of strings of length n that can be made using ‘a’, ‘b’ and ‘c’ with at-most one ‘b’ and two ‘c’s allowed.

     */

    public static void main(String[] args) {

        int n =3;
        System.out.println(countStrings(n,1,2));
        int bCount = 1;
        int cCount = 2;

        Integer[][][] dp = new Integer[n+1][bCount+1][cCount+1];
        System.out.println(countStringsDP(n,bCount,cCount,dp));
    }

    public static int countStrings(int n, int bCount, int cCount){
        //base cases
        if(bCount < 0 || cCount < 0)
            return 0;
        if(n == 0)
            return 1;

        if(bCount == 0 && cCount == 0)
            return 1;
        //For a
        //for b
        //for c
        return countStrings(n-1,bCount,cCount)+countStrings(n-1,bCount-1,cCount)+countStrings(n-1,bCount,cCount-1);
    }

    //DP way as this problem leads to O(3n) exponential and we will have overlapping sub problems

    public static int countStringsDP(int n, int bCount, int cCount, Integer[][][] dp){
        if(bCount < 0 || cCount<0)
            return 0;
        if(n == 0)
            return 1;
        if(bCount == 0 && cCount == 0)
            return 1;

        if(dp[n][bCount][cCount] != null )
            return dp[n][bCount][cCount];

        dp[n][bCount][cCount] = countStringsDP(n-1,bCount,cCount,dp)+countStringsDP(n-1,bCount-1,cCount,dp)+countStringsDP(n-1,bCount,cCount-1,dp);
        return dp[n][bCount][cCount];
    }

}
