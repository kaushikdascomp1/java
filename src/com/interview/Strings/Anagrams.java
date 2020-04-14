package src.com.interview.Strings;

import java.util.*;

public class Anagrams {

    //Print all anagrams together
    //https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
    //Given an array of words, print all anagrams together.
    // For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”}, then output may be “cat tac act dog god”.
    public static void main(String[] args) {
        String[] arr = {"cat", "dog", "tac", "god", "act"};
        printAnagrams(arr);

        //output
        //[cat, tac, act]
        //[dog, god]
    }

    private static void printAnagrams(String arr[]){
        Map<String, List<String>> wordMap = new HashMap<>();
        List<List<String>> outputVal = new ArrayList<>();
        Arrays.stream(arr).forEach(e->{
            char[] newArr = e.toCharArray();
            Arrays.sort(newArr);
            String newWord = new String(newArr);
            if(wordMap.containsKey(newWord)){
                wordMap.get(newWord).add(e);
            }else {
                List<String> wordList = new ArrayList<>();
                wordList.add(e);
                wordMap.put(newWord,wordList);
            }
        });

        for(String key:wordMap.keySet()){
            List<String> values = wordMap.get(key);
            if(values.size()>1)
                System.out.println(values);
        }

    }
}
