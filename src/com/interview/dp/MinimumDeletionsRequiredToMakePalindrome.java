package src.com.interview.dp;

public class MinimumDeletionsRequiredToMakePalindrome {

    /**
     * Given a string, find the minimum number of deletions required to make it a palindrome
     * Minimum Insertions required and minimum deletions required are same
     */

    public static void main(String[] args) {
        System.out.println(minimumDeletions("abdbca"));
        //o/p should be 1 as removing either c or d will provide the result
        System.out.println(minimumDeletionsDP("abdbca"));
        System.out.println(minimumDeletions("abcd"));
        //o/p 3

        System.out.println(minimumDeletionsDP("abcd"));
        //o/p 3
    }


    public static int minimumDeletions(String string) {
        return findMinimumDeletions(string, 0, string.length() - 1);
    }

    public static int findMinimumDeletions(String string, int start, int end) {
        if (start >= end)
            return 0;

        if (string.charAt(start) == string.charAt(end)) {
            return findMinimumDeletions(string, start + 1, end - 1);
        }

        return 1 + Math.min(findMinimumDeletions(string, start + 1, end), findMinimumDeletions(string, start, end - 1));
    }

    //As there are overlapping sub problems we try to solve it using memoization
    public static int minimumDeletionsDP(String string) {
        Integer[][] dp = new Integer[string.length() + 1][string.length() + 1];
        return findMinimumDeletionsDP(string, 0, string.length() - 1, dp);
    }

    public static int findMinimumDeletionsDP(String str, int start, int end, Integer[][] dp) {
        if (start >= end)
            return 0;
        if (dp[start][end] != null)
            return dp[start][end];
        if (str.charAt(start) == str.charAt(end)) {
            dp[start][end] = findMinimumDeletionsDP(str, start + 1, end - 1, dp);
        }

        dp[start][end] = 1 + Math.min(findMinimumDeletionsDP(str, start + 1, end, dp), findMinimumDeletionsDP(str, start, end - 1, dp));
        return str.length() - dp[start][end];

    }
}
