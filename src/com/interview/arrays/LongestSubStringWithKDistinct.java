package src.com.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKDistinct {

    //Given a string, find the length of the longest substring in it with no more than K distinct characters.

    public static void main(String[] args) {

    }

    public static int kDistinct(String str, int k){
        Map<Character, Integer> mapList = new HashMap<Character, Integer>();
        int windowStart = 0;
        int maxLength = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            mapList.put(rightChar,mapList.getOrDefault(rightChar,0)+1);

            if(mapList.size() > k){
              char leftChar = str.charAt(windowStart);
              mapList.put(leftChar,mapList.getOrDefault(leftChar,0)-1);
              if(mapList.get(leftChar) == 0)
                  mapList.remove(leftChar);
              windowStart++;

            }
            maxLength = Math.max(maxLength,windowEnd-windowStart+1);
        }
        return maxLength;
    }

}
