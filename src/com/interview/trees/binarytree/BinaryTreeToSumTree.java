package src.com.interview.trees.binarytree;

import src.com.interview.trees.model.Node;

public class BinaryTreeToSumTree {

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(-2);
        node.left.left = new Node(8);
        node.left.right = new Node(-4);

        node.right = new Node(6);
        node.right.left = new Node(7);
        node.right.right = new Node(5);


        sumTree(node);
        System.out.println("Valies are::  ");
    }

    public static int sumTree(Node root){
        if(null == root)
            return 0;
        //It's a leaf node, make this to zero
        int oldVal = root.value;
       root.value = sumTree(root.left) + sumTree(root.right);
       return oldVal + root.value;
    }
}
