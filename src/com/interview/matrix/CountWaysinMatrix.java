package src.com.interview.matrix;

public class CountWaysinMatrix {

    //To count the number of ways to can reach the end of the matrix by taking only right and down

    public static int countWays(int[][] mat, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        return countWays(mat, m - 1, n) + countWays(mat, m, n - 1) + countWays(mat, m - 1, n - 1);
    }

    public static int countWays(int[][] mat, int m, int n, Integer[][] dp){
        if(m == 0 || n == 0)
            return 0;
        if(dp[m][n] != null)
            return dp[m][n];
        dp[m][n] = countWays(mat, m - 1, n) + countWays(mat, m, n - 1) + countWays(mat, m - 1, n - 1);
        return dp[m][n];
    }
}
