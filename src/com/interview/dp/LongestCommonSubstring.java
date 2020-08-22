package src.com.interview.dp;

public class LongestCommonSubstring {

    public static void main(String[] args) {
            String str1 = "abdca";
            String str2 = "cbda";
        System.out.println(findLongest(str1,str2,0,0,0));
    }

    public static int findLongest(String str1, String str2, int i1, int i2, int count){
        //base condition
        if(i1 == str1.length() || i2 == str2.length())
            return count;

        if(str1.charAt(i1) == str2.charAt(i2))
            count = findLongest(str1, str2, i1+1, i2+1, count+1);

        int c1 = findLongest(str1, str2, i1+1, i2, 0);
        int c2 = findLongest(str1, str2, i1, i2+1, 0);

        return Math.max(count, Math.max(c1,c2));
    }
}
