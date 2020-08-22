package src.com.interview.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WordLadder {

    /*
    Given two words (start and end), and a dictionary, find the length of shortest transformation
    sequence from start to end, such that only one letter can be changed at a time
    and each intermediate word must exist in the dictionary. For example, given
    start = "hit"
    end = "cog"
    dict = ["hot","dot","dog","lot","log"]
    One shortest transformation is "hit" ->"hot" ->"dot" ->"dog" ->"cog", the program
    should return its length 5.

     */
    public class WordNode{
        public String word;
        public int steps;

        public WordNode(String word, int steps){
            this.word = word;
            this.steps = steps;
        }

        public String getWord(){
            return this.word;
        }

        public int getSteps() {
            return steps;
        }
    }

    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        Set<String> set = new HashSet<>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        WordLadder ladder = new WordLadder();
        System.out.println(ladder.findSteps(begin,end,set));
    }

    public int findSteps(String beginWord, String endWord, Set<String> dict){
        WordNode wordNode = new WordNode(beginWord,1);
        LinkedList<WordNode> queue = new LinkedList<>();
        queue.add(wordNode);

        dict.add(endWord);

        while (!queue.isEmpty()){
            WordNode wd = queue.poll();
            if(wd.getWord().equals(endWord))
                return wd.getSteps();

            char[] arr = wd.getWord().toCharArray();
            for(int i=0;i<arr.length;i++){
                for(char c='a';c<='z';c++){
                    char temp = arr[i];
                    if(arr[i] != c){
                        arr[i] = c;
                    }

                    String newWord = new String(arr);
                    if(dict.contains(newWord)){
                        queue.add(new WordNode(newWord,wd.getSteps()+1));
                        dict.remove(newWord);
                    }
                    arr[i] = temp;
                }
            }
        }
        return 0;
    }


}
