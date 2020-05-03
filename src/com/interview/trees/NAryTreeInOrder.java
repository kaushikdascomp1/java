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

    //Traversing an NAry in inorder traversal

    public static void inOrderNAry(Node node){
        if(node == null)
            return;
        //Traversing n-1 nodes
        int total = node.children.length;
        for (int i=0;i<total-1;i++){
            inOrderNAry(node.children[i]);
        }
        //printing all values
        System.out.println(node.val);
        //Traversing the nth node
        inOrderNAry(node.children[total-1]);
    }


}
