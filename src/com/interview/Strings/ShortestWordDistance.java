package src.com.interview.Strings;

public class ShortestWordDistance {

    /*
    Given a list of words and two words word1 and word2, return the shortest distance
    between these two words in the list.
    For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
    Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes",
    word2 = "coding", return 1.
     */

    public static void main(String[] args) {
            String[] words = {"practice", "makes", "perfect", "coding", "makes"};
            String word1 = "coding";
            String word2 = "practice";
        System.out.println(shortestWordDist(words,word1,word2));
        //o/p = 3
    }

    public static int shortestWordDist(String[] words, String word1, String word2) {
        int m = -1;
        int n = -1;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                m = i;
                if (n != -1)
                    min = Math.min(min, m - n);
            } else if (words[i].equals(word2)) {
                n = i;
                if (m != -1)
                    min = Math.min(min, n - m);
            }

        }

        return min;
    }
}
