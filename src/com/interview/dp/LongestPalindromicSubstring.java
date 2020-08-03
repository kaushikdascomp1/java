package src.com.interview.dp;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String string = "geeksforgeeks";

        System.out.println(findLongestRecursive(string));
    }

    public static int findLongestRecursive(String str){
            return longestPalin(str,0,str.length()-1);
    }

    public static int longestPalin(String string, int start, int end){
        if(start > end)
            return 0;
        if(start == end)
            return 1;
        if(string.charAt(start) == string.charAt(end)){
            int rem = end -start-1;
            if(rem == longestPalin(string,start+1,end-1))
                return 2+rem;
        }
        int c1 = longestPalin(string,start+1,end);
        int c2 = longestPalin(string,start,end-1);
        return Math.max(c1,c2);
    }
}
