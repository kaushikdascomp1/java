package src.com.interview.graph;

import scala.Char;

import java.util.*;

public class AlienDictionary {

    /*
        There is a dictionary containing words from an alien language for which we don’t know the ordering of the characters.
        Write a method to find the correct order of characters in the alien language.
        Input: Words: ["ba", "bc", "ac", "cab"]
        Output: bac
     */
    public static void main(String[] args) {
        String result = AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab" });
        System.out.println(result);
    }

    public static String findOrder(String[] words){
        StringBuilder sortedOrder = new StringBuilder();
        if(null == words || words.length == 0)
            return "";

        //initialize Graph
        Map<Character, Integer> inDegree = new HashMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();

        for (String word:words){
            for (Character charSeq:word.toCharArray()){
                inDegree.put(charSeq,0);
                graph.put(charSeq,new ArrayList<>());
            }
        }

        //build graph
        for(int i=0;i<words.length-1;i++){
            String w1 = words[i];
            String w2 = words[i+1];
            for(int j=0;j<Math.min(w1.length(),w2.length());j++){
                char parent = w1.charAt(j);
                char child = w2.charAt(j);
                if(parent != child){ //If both the two characters are different
                    graph.get(parent).add(child);  //put the child into parent's list
                    inDegree.put(child,inDegree.get(child)+1);
                    break; //Only the first different character will help us in finding the sequence
                }
            }
        }

        //build queue
        //find all sources from vertices
        Queue<Character> queue = new LinkedList<>();
        for(Map.Entry<Character,Integer> entry:inDegree.entrySet()){
            if (entry.getValue() == 0)
                queue.add(entry.getKey());
        }

        //For each source, add it to the sorted order and substract one from it's indegree
        //if child's indegree becomes zer add it to the queue
        while (!queue.isEmpty()){
            char vertex = queue.poll();
            sortedOrder.append(vertex);
            List<Character> children = graph.get(vertex);
            for(Character child:children){
                inDegree.put(child,inDegree.get(child)-1);
                if(inDegree.get(child) == 0)
                    queue.add(child);
            }
        }

        if(sortedOrder.length() != inDegree.size())
            return "";

        return sortedOrder.toString();

    }

}
