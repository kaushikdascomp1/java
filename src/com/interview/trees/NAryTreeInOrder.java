package src.com.interview.trees;

public class NAryTreeInOrder {

    public static void main(String[] args) {

    }

    //Just like a Trie Node
    static class Node{
        int val;
        Node children[];

        public Node(int val, int n){
            this.val = val;
            children = new Node[n];
        }
    }


}
