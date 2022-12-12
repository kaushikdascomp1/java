package Trie;

public class SumOfPrefixScores {

    /*
    You are given an array words of size n consisting of non-empty strings.
    We define the score of a string word as the number of strings words[i] such that word is a prefix of words[i].
    For example, if words = ["a", "ab", "abc", "cab"], then the score of "ab" is 2, since "ab" is a prefix of both "ab" and "abc".
    Return an array answer of size n where answer[i] is the sum of scores of every non-empty prefix of words[i].

    Note that a string is considered as a prefix of itself.
    Input: words = ["abc","ab","bc","b"]
    Output: [5,4,3,2]
    Explanation: The answer for each string is the following:
    - "abc" has 3 prefixes: "a", "ab", and "abc".
    - There are 2 strings with the prefix "a", 2 strings with the prefix "ab", and 1 string with the prefix "abc".
    The total is answer[0] = 2 + 2 + 1 = 5.
    - "ab" has 2 prefixes: "a" and "ab".
    - There are 2 strings with the prefix "a", and 2 strings with the prefix "ab".
    The total is answer[1] = 2 + 2 = 4.
    - "bc" has 2 prefixes: "b" and "bc".
    - There are 2 strings with the prefix "b", and 1 string with the prefix "bc".
    The total is answer[2] = 2 + 1 = 3.
    - "b" has 1 prefix: "b".
    - There are 2 strings with the prefix "b".
    The total is answer[3] = 2.
     */
    public static void main(String[] args) {
        SumOfPrefixScores scores = new SumOfPrefixScores();
        String[] words = {"abc","ab","bc","b"};
        System.out.println(scores.sumPrefixScores(words));
    }

    class TrieNodePrefix{
        int count;
        TrieNodePrefix[] children;

        public TrieNodePrefix() {
            this.count = 0;
            this.children = new TrieNodePrefix[26];
        }
    }

    public void insert(TrieNodePrefix root, String str){
        TrieNodePrefix node = root;

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(node.children[ch - 'a'] == null){
                node.children[ch - 'a'] = new TrieNodePrefix();
            }

            node.children[ch - 'a'].count++;
            node = node.children[ch - 'a'];
        }
    }

    public int getScore(TrieNodePrefix root, String str){
        int score = 0;
        TrieNodePrefix node = root;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            score += node.children[ch - 'a'].count;
            node = node.children[ch - 'a'];
        }

        return score;
    }

    public int[] sumPrefixScores(String[] words){
        int n = words.length;

        int[] result = new int[n];
        TrieNodePrefix root = new TrieNodePrefix();
        for(int i=0;i< words.length;i++){
            insert(root, words[i]);
        }

        //getCount of all prefixes
        for(int i=0;i< words.length;i++){
            result[i] = getScore(root, words[i]);
        }

        return result;
    }

}
