package src.com.interview.Trie;

public class StreamChecker {

    /**
     * Implement the StreamChecker class as follows:
     *
     * StreamChecker(words): Constructor, init the data structure with the given words.
     * query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest,
     * including this letter just queried) spell one of the words in the given list.
     *
     * StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]);
     * streamChecker.query('a');          // return false
     * streamChecker.query('b');          // return false
     * streamChecker.query('c');          // return false
     * streamChecker.query('d');          // return true, because 'cd' is in the wordlist
     *
     * Main Idea is to create the trie tree in reverse order
     */
    class Trie{
        int val;
        boolean wordEnd;
        Trie[] next;

        public Trie(int val, boolean wordEnd, Trie[] next){
            this.val=val;
            this.wordEnd=wordEnd;
            this.next=next;
        }
    }

    Trie[] t;
    StringBuilder stream;

    public StreamChecker(String[] words){
        t = new Trie[26];
        stream = new StringBuilder();
        for(String word:words)
            insert(word);
    }

    public void insert(String word){
       Trie[] st = t;
        Trie curr = null;
        for(int i = word.length()-1;i>=0;i--){
           int val = word.charAt(i)- 'a';
           curr = st[val];
           if(curr == null){
               curr = new Trie(val,false,new Trie[26]);
               st[val] = curr;
           }
           if(i == 0)
               curr.wordEnd = true;
           st = curr.next;
        }
    }

    public boolean query(char letter){
        stream.append(letter);
        Trie p = null;
        Trie[] st = t;

        for(int i = stream.length()-1;i>=0;i--){
            char c = stream.charAt(i);
            int val = c-'a';
            p = st[val];
            if(p!=null){
                if(p.wordEnd)
                    return true;
                st=p.next;
            }else
                return false;
        }

        return false;

    }

    public static void main(String[] args) {
        String[] words = {"cd","f","kl"};
        StreamChecker streamChecker = new StreamChecker(words);
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('c'));;
        System.out.println(streamChecker.query('d'));

    }



}
