package src.com.interview.Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakProblem {

    /**
     * Based on finding all subsets of a string
     * Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words.
     * See following examples for more details.
     * <p>
     * Consider the following dictionary
     * { i, like, sam, sung, samsung, mobile, ice,
     * cream, icecream, man, go, mango}
     * <p>
     * Input:  ilike
     * Output: Yes
     * The string can be segmented as "i like".
     */

    //public static final String dict[] = {"i", "like", "sam", "sung", "samsung", "mobile", "ice"};
    public static void main(String[] args) {
        List<String> allsubsets = AllSubsetsOfAString.findSubsets("ilike");
        String dict[] = {"i", "like", "sam", "sung", "samsung", "mobile", "ice"};
        boolean wordBreak = wordBreak("ilike", dict);


    }

    public static boolean wordBreak(String str, String[] dict){
        Set<String> dictionarySet = new HashSet<>();
        Arrays.stream(dict).forEach(e->dictionarySet.add(e));
            //// Now we will first divide the word into two parts ,
        //            // the prefix will have a length of i and check if it is
        //            // present in dictionary ,if yes then we will check for
        //            // suffix of length size-i recursively. if both prefix and
        //            // suffix are present the word is found in dictionary.
        for(int i=0;i<str.length();i++){
            if(dictionarySet.contains(str.substring(0,i)) && wordBreak(str.substring(i,str.length()-1),dict))
                return true;
        }

        return false;

    }
}