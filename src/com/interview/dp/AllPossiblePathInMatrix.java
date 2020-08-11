package src.com.interview.dp;

import java.util.Stack;

public class AllPossiblePathInMatrix {

    /**
     * COunt of all possible path in a matrix
     *
     * @param args
     */

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(countPossiblePaths(mat, 3, 3));
        Integer[][] dp = new Integer[4][4];
        Stack<Integer> route = new Stack<>();
        System.out.println(countPossibleWaysDP(mat,3,3,dp, route));
    }

    public static int countPossiblePaths(int[][] mat, int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        return countPossiblePaths(mat, m - 1, n) + countPossiblePaths(mat, m, n - 1);
    }

    public static int countPossibleWaysDP(int[][] mat, int m, int n, Integer[][] dp, Stack<Integer> route) {
        if (m == 1 || n == 1)
            return 1;
        route.add(mat[m-1][n-1]);
        if (dp[m][n] != null) {
            return dp[m][n];
        }
        if(m == 2 && n == 2)
            System.out.println(route);
        else {
            dp[m][n] = countPossibleWaysDP(mat, m - 1, n, dp, route) + countPossibleWaysDP(mat, m, n - 1, dp, route);
        }





        route.pop();
        return dp[m][n];
    }
}
