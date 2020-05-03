package src.com.interview.trees;

import src.com.interview.trees.model.Node;

public class AreIdenticalTrees {

    public static void main(String[] args) {
        Node bt1 = new Node(1);
        bt1.left = new Node(2);
        bt1.right = new Node(3);
        bt1.left.left = new Node(4);
        bt1.right.left = new Node(5);
        bt1.right.right = new Node(6);

        //Adding nodes to the second binary tree
        Node bt2 = new Node(1);
        bt2.left = new Node(2);
        bt2.right = new Node(3);
        bt2.left.left = new Node(4);
        bt2.right.left = new Node(5);
        //changed to different value of tree
        bt2.right.right = new Node(7);
        System.out.println(areIdentical(bt1,bt2));
    }

    public static boolean areIdentical(Node tree1, Node tree2){
        if(null == tree1 && null == tree2)
            return true;

        return (tree1.value == tree2.value && areIdentical(tree1.left,tree2.left) && areIdentical(tree1.right,tree2.right));
    }
}
