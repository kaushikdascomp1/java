package src.com.interview.dp;

public class MinimumInsertionsRequiredToMakePalindrome {

    /*
    Given a string find the minimum number of insertions required to make it a palindrome
    Algo for minimum Insertins required and minimum deltions required is same
     */

    public static void main(String[] args) {
        System.out.println(findMinimum("abcd"));

        //o/p should be 3 as dcbabcd 3 insertions are required
        System.out.println(findMinimumDP("abcd"));
    }

    public static int findMinimum(String string) {
        return findMinimumRecursive(string, 0, string.length() - 1);
    }

    private static int findMinimumRecursive(String str, int start, int end) {
        if (start >= end) {
            return 0;
        }

        if (str.charAt(start) == str.charAt(end)) {
            return findMinimumRecursive(str, start + 1, end - 1);
        }

        return 1 + Math.min(findMinimumRecursive(str, start + 1, end), findMinimumRecursive(str, start, end - 1));
    }


    //Solve it using dynamic programmig using memoization
    public static int findMinimumDP(String str) {
        Integer[][] dp = new Integer[str.length() + 1][str.length() + 1];
        return findMinimumInsertionsDP(str, 0, str.length() - 1, dp);
    }

    public static int findMinimumInsertionsDP(String str, int start, int end, Integer[][] dp) {
        if (start >= end)
            return 0;

        if (dp[start][end] != null)
            return dp[start][end];
        if (str.charAt(start) == str.charAt(end)) {
            dp[start][end] = findMinimumInsertionsDP(str, start + 1, end - 1, dp);
        }

        dp[start][end] = 1 + Math.min(findMinimumInsertionsDP(str, start + 1, end, dp), findMinimumInsertionsDP(str, start, end - 1, dp));
        return dp[start][end];
    }
}
