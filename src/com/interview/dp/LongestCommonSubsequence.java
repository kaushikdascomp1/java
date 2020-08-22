package src.com.interview.dp;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String str1 = "abdca";
        String str2 = "cbda";
        System.out.println(findLongestSubsequence(str1,str2,0,0));
    }

    public static int findLongestSubsequence(String str1, String str2, int i1, int i2){
        if(i1 == str1.length() || i2 == str2.length())
            return 0;

        if(str1.charAt(i1) == str2.charAt(i2))
            return 1+findLongestSubsequence(str1, str2, i1+1, i2+1);

        int c1 = findLongestSubsequence(str1, str2, i1+1, i2);
        int c2 = findLongestSubsequence(str1, str2, i1, i2+1);
        return Math.max(c1,c2);
    }
}
