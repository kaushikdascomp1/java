package com.interview.arrays;

import org.apache.commons.lang3.StringUtils;

public class LongestCommonPrefix {

    //["flower","flo", "flow"]
    //Find the longest common prefix

    public static void main(String[] args) {
        String[] strs = {"flower", "flo", "flow"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs){
        if(strs.length == 0){
            return StringUtils.EMPTY;
        }
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){
            while (strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty())
                    return StringUtils.EMPTY;
            }
        }
        return prefix;
    }
}
