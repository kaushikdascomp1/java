package src.com.interview.dp;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        //eekee or eesee
        System.out.println(longestPalindromicSubse(str));
    }

    public static int longestPalindromicSubse(String string){
        return longestPalinSubsequence(string,0,string.length()-1);
    }

    public static int longestPalinSubsequence(String str, int start, int end){
        //base conditions
        if(start > end)
            return 0;
        if(start == end)
            return 1;
        if(str.charAt(start) == str.charAt(end)){
            return 2+longestPalinSubsequence(str,start+1,end-1);
        }

        int c1 = longestPalinSubsequence(str,start+1,end);
        int c2 = longestPalinSubsequence(str,start,end-1);
        return Math.max(c1,c2);

    }
}
