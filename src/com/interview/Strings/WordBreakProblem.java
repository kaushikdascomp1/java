package src.com.interview.Strings;

import java.util.*;

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

        Set<String> dictionarySet = new HashSet<>();
        Arrays.stream(dict).forEach(e->dictionarySet.add(e));
        boolean wordBreak = wordBreak("ilikesamsung", dictionarySet);
        System.out.println("Recursive Sol:: "+wordBreak);

        String str = "ilikesamsung";
        int[] lookup = new int[str.length()+1];
        Arrays.fill(lookup,-1);
        boolean wordBreakDP = wordBreakDP(str, dictionarySet,lookup);
        System.out.println("DP Sol: "+wordBreakDP);
    }

    public static boolean wordBreak(String str, Set<String> dictionarySet){

         // Now we will first divide the word into two parts ,
               // the prefix will have a length of i and check if it is
                    // present in dictionary ,if yes then we will check for
                    // suffix of length size-i recursively. if both prefix and
                    // suffix are present the word is found in dictionary.
        if(str.length() == 0)
            return true;
        for(int i=1;i<=str.length();i++){
            if(dictionarySet.contains(str.substring(0,i)) && wordBreak(str.substring(i,str.length()),dictionarySet))
                return true;
        }
        return false;
    }

    public static boolean wordBreakDP(String str, Set<String> dictionarySet, int[] lookup){

        int n = str.length();
        if(n == 0)
            return true;
        //If subproblems is seen for first time
        if(lookup[n] == -1){
            //intialize lookup as 0 means seen
            lookup[n] = 0;
            for(int i=1;i<=n;i++){
                if(dictionarySet.contains(str.substring(0,i)) && wordBreakDP(str.substring(i,n),dictionarySet,lookup)){
                    lookup[n] = 1;
                    return true;
                }

            }
        }
            return lookup[n] == 1;
    }


    public boolean wordBreakDPMap(String s,Set dict){
        HashMap<String, Boolean> map = new HashMap();
        return wordBreakMap(s, dict,map);
    }

    public boolean wordBreakMap(String s,Set dict,HashMap<String, Boolean> map){

        if(map.containsKey(s)){
            return map.get(s);
        }

        for (int i = 0; i <= s.length(); i++) {
            String prefix = s.substring(0,i);
            if(dict.contains(prefix)){
                if(i == s.length()){
                    return true;
                }
                if(wordBreakMap(s.substring(i),dict,map)){
                    map.put(s.substring(i), true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}