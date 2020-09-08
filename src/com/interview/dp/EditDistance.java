package src.com.interview.dp;

public class EditDistance {

    /*
    Given two strings, find minimum edit distance required to convert string a into string b
     */

    public static void main(String[] args) {
        String x = "saturday";
        String y = "sunday";
        System.out.println(editDistance(x,y,x.length(),y.length()));
        Integer[][] dp = new Integer[x.length()][y.length()];
        System.out.println(editDistanceDP(x,y,x.length(),y.length(),dp));
    }

    public static int editDistance(String x, String y, int m, int n){
        if(m == 0)
            return n;
        if(n == 0)
            return m;
        if(x.charAt(m-1) == y.charAt(n-1))
            return editDistance(x,y,m-1,n-1);

        return 1+Math.min(editDistance(x,y,m,n-1),Math.min(editDistance(x,y,m-1,n),editDistance(x,y,m-1,n-1)));
    }

    public static int editDistanceDP(String x, String y, int m, int n, Integer[][] dp){
        if(m == 0)
            return n;
        if(n == 0)
            return m;
        if(dp[m-1][n-1] != null)
            return dp[m-1][n-1];
        if(x.charAt(m-1) == y.charAt(n-1)){
            dp[m-1][n-1] = editDistanceDP(x,y,m-1,n-1,dp);
        }else {
            dp[m-1][n-1]= 1+Math.min(editDistance(x,y,m,n-1),Math.min(editDistance(x,y,m-1,n),editDistance(x,y,m-1,n-1)));
        }
        return dp[m-1][n-1];
    }
}
