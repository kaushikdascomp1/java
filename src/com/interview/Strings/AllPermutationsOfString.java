package src.com.interview.Strings;

public class AllPermutationsOfString {

    /**
     * To find the all permutations of a string
     * https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
     * Algorithm used: Backtracking
     * O(n*n!)
     */

    public static void main(String[] args) {
        permute("ABC",0,2);
    }

    public static void permute(String str, int l, int r){
        if(str.length() == 0)
            System.out.println("Please enter a valid string::");
        if(l == r)
            System.out.println(str);
        else {
            for(int i=l;i<=r;i++){
                str = swap(str,l,i);
                permute(str,l+1,r);
                str = swap(str,l,i);
            }
        }

    }

    private static String swap(String str, int l, int i) {
        char temp;
        char[] strArray = str.toCharArray();
        temp = strArray[l];
        strArray[l] = strArray[i];
        strArray[i] = temp;
        return String.valueOf(strArray);
    }
}
