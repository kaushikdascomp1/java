package src.com.interview.Strings;



public class LongestRepeatingSubstring {

    public static void main(String args[]) {
        System.out.println(longestRepeating("geeksforgeeks"));
    }

    public static String longestRepeatingRecursive(String str){
        for (int i = 1; i <= str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {

            }
        }
        return "";
    }
    //Using DP Bottom Up- Tabulation approach
    public static String longestRepeating(String str) {
        int n = str.length();
        int LcsR[][] = new int[n + 1][n + 1];
        int resultLen = 0;
        int index = 0;
        String res = "";
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && LcsR[i - 1][j - 1] < (j - i)) {
                    LcsR[i][j] = LcsR[i - 1][j - 1] + 1;
                    if (LcsR[i][j] > resultLen) {
                        resultLen = LcsR[i][j];
                        index = Math.max(index, i);
                    }
                } else {
                    LcsR[i][j] = 0;
                }
            }
        }

        if (resultLen > 0) {
            for (int i = index - resultLen + 1; i <= index; i++) {
                res = res + str.charAt(i - 1);
            }
        }
        return res;
    }
}
