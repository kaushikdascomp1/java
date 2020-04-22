package src.com.interview.Strings;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsOfAString {

    /**
     * The subset of a string is the character or the group of characters that are present inside the string.
     * For example, all possible subsets of a string "FUN" will be F, U, N, FU, UN, FUN.
     * o/p: A
     * AB
     * ABC
     * B
     * BC
     * C
     *
     * Total combinations are: n(n+1)/2
     *
     * @param args
     */

    public static void main(String[] args) {
        findSubsets("ABC");
    }

    public static List<String> findSubsets(String str){
        List<String> subsetList = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
                subsetList.add(str.substring(i,j+1));
            }
        }

        subsetList.stream().forEach(System.out::println);
        return subsetList;
    }
}
