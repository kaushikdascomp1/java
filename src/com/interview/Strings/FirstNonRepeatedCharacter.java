package src.com.interview.Strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {

    static final int char_count = 256;
    static char[] count = new char[char_count];

    public static void main(String[] args) {
        String str = "GeeksForGeeks";
        int index = getIndex(str);
        System.out.println("First Non-repeated chracter is: "+str.charAt(index));

        getChars(str);

        //kthNonRepeated
        kthgetChars(str,3);
    }
    // Traversing the String twice-- Once to update the char count and second to find the count with one
    //Time complexity O(n) Space complexity O(256)
    public static void getCharCount(String str){
        for(int i=0;i<str.length();i++){
            count[str.charAt(i)]++;
        }
    }

    public static int getIndex(String str){
        getCharCount(str);
        int index = -1;

        for (int i=0;i<str.length();i++){
            if(count[str.charAt(i)] == 1){
                index=i;
                break;
            }
        }
        return index;
    }

    //Hashmap approach to traverse the array once

    public static void getChars(String str){
        Map<Character, Integer> charMap = new LinkedHashMap<Character, Integer>();

        for(int i=0;i<str.length();i++){
            if(charMap.containsKey(str.charAt(i))){
                charMap.put(str.charAt(i),charMap.get(str.charAt(i))+1);
            }else{
                charMap.put(str.charAt(i),1);
            }
        }
        for(Map.Entry<Character,Integer> map:charMap.entrySet()){
            if(map.getValue()==1){
                System.out.println("First Non repeated is:"+ map.getKey());
                break;
            }

        }

    }

    //kth Non-repeated character
    public static void kthgetChars(String str, int value){
        Map<Character, Integer> charMap = new LinkedHashMap<Character, Integer>();

        for(int i=0;i<str.length();i++){
            if(charMap.containsKey(str.charAt(i))){
                charMap.put(str.charAt(i),charMap.get(str.charAt(i))+1);
            }else{
                charMap.put(str.charAt(i),1);
            }
        }
        for(Map.Entry<Character,Integer> map:charMap.entrySet()){
            if(map.getValue()==1){
                if(value == 1){
                    System.out.println("First Non repeated is:"+ map.getKey());
                    break;
                }else{
                    value--;
                }
            }

        }

    }

}
