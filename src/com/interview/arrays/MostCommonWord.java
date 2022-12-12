package arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class MostCommonWord {

    /*
    Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned.
    It is guaranteed there is at least one word that is not banned, and that the answer is unique.

    The words in paragraph are case-insensitive and the answer should be returned in lowercase.
    Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
    Output: "ball"
    Explanation:
    "hit" occurs 3 times, but it is a banned word.
    "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
     */

    public static void main(String[] args) {
        String[] banned = {"hit"};
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        System.out.println(mostCommonWord(paragraph, banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        String newParagraph = paragraph.replaceAll("\\p{Punct}", "");
        String[] splitWords = newParagraph.split(" ");
        Map<String, Integer> freqMap = new HashMap<>();
        for(String word: splitWords){
            freqMap.put(word.toLowerCase(), freqMap.getOrDefault(word.toLowerCase(),0)+1);
        }

        LinkedHashMap<String, Integer> sortedMap = freqMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        for(String word: banned){
            sortedMap.remove(word);
        }
        return sortedMap.entrySet().stream().findFirst().get().getKey();
    }

}
