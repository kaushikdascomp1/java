package src.com.interview.Trie;

import java.util.Map;

public class Trie {

    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        if(word.length()<=0)
            return;
        Map<Character, TrieNode> children = root.children;
        TrieNode t;

        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
            }else {
                t = new TrieNode(c);
                children.put(c,t);
            }

            children = t.children;
            if(i == word.length()-1){
                t.isLeaf = true;
            }
        }
    }

    public boolean search(String word){
        return false;
    }

    public TrieNode searchNode(String word){
        TrieNode t= null;
        if(word.length()<=0) {
            return t;
        }

        Map<Character, TrieNode> children = root.children;
        for(int i =0;i<word.length();i++){
            char c = word.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }else {
                return null;
            }
        }

        return t;
    }
}
