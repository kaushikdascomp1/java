package src.GSCoderPad;

public class ShortestDistance {

    /**
     * Given two words, return the shortest distance between the words.
     * The words can appear multiple times and in any order    *
     *
     */

    public static void main(String[] args) {
        String s = "the quick the brown quick brown the frog";
        String w1 = "quick";
        String w2 = "frog";
        checkDistance(s,w1,w2);

        String s1 = "geeks for geeks contribute practice";
        String ww1 = "geeks";
        String ww2 = "practice";
        checkDistance(s1,ww1,ww2);
        shortestDistance(s1,ww1,ww2);

        String s2 = "This is a sample document";
        String word1 = "is";
        String word2 = "a";
        shortestDistance(s2,word1,word2);
    }

    public static double shortestDistance(String document, String word1, String word2){
        String[] words = document.split(" ");

        double index = 0;
        double shortest = document.length();
        double word1loc = 0;
        double word2loc = 0;
        for(String word: words){
            if(word.equals(word1)){
                word1loc = index + (word.length()/2.0);
                System.out.println(word1 + "==== word1loc "+word1loc);
            }else if(word.equals(word2)){
                word2loc = index + (word.length()/2.0);
                System.out.println(word2 + "==== word2loc "+word2loc);
            }

            if(word1loc > 0 && word2loc > 0 && word1loc>word2loc){
                double current = (word2loc-word1loc)+1;
                if(current<shortest && current>0){
                    shortest = current;
                    System.out.println("Shortest Value is:  "+shortest);
                }
                word1loc = 0;
                word2loc = 0;
            }
            index +=word.length();
        }
        if(word1loc == 0 || word2loc == 0){
            return -1;
        }
        System.out.println("Shortest is: "+shortest);
        return shortest;
    }

    /*
    Complexity O(n^2)
    Take two for loops and for every occurence of w1, store the index1 check in the second loop if w2 exists and store the index2
    Math.abs(diff of two indexes)
    */

    public static void checkDistance(String document, String word1, String word2){
        String[] words = document.split(" ");
        int distance = document.length();
        int index1 = 0;
        int index2 = 0;

       for(int i=0;i<words.length;i++){
           if(words[i].equals(word1)){
               index1 = i;
           }else if(words[i].equals(word2)){
               index2 = i;
           }
       }
        System.out.println(Math.abs(index1-index2)-1);
    }
}
