package src.com.interview.Strings;

public class SmallestWindowOfString {

    /**
     * Difficult problem
     * Find the smallest window in a string containing all characters of another string
     * https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
     *
     */

    static final int no_of_chars = 256;
    public static void main(String[] args) {
        String str = "this is a test string";
        String pat = "tist";
        int len1 = str.length();
        int len2 = pat.length();
        int hash_pat[] = new int[no_of_chars];
        int hash_str[] = new int[no_of_chars];
        for (int i = 0; i < len2; i++)
            hash_pat[pat.charAt(i)]++;


    }


}
