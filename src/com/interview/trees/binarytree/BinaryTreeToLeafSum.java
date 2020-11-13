package src.com.interview.trees.binarytree;

import src.com.interview.trees.model.Node;

import java.util.*;

public class BinaryTreeToLeafSum {

    /**
     *  Given a binary tree, where every node value is a Digit from 1-9 .Find the sum of all the numbers which are formed from root to leaf paths.
     * For example consider the following Binary Tree.
     *
     *            6
     *        /      \
     *      3          5
     *    /   \          \
     *   2     5          4
     *       /   \
     *      7     4
     *   There are 4 leaves, hence 4 root to leaf paths:
     *    Path                    Number
     *   6->3->2                   632
     *   6->3->5->7               6357
     *   6->3->5->4               6354
     *   6->5>4                    654
     * Answer = 632 + 6357 + 6354 + 654 = 13997
     */

    public static void main(String[] args) {
        Node node = new Node(6);
        node.left = new Node(3);
        node.left.left = new Node(2);
        node.left.right = new Node(5);
        node.left.right.left = new Node(7);
        node.left.right.right = new Node(4);

        node.right = new Node(5);
        node.right.right = new Node(4);

        System.out.println(sumTree(node,0));
        //Printed 13997

        //Print all pathsfrom root to leaf
        BinaryTreeToLeafSum binaryTreeToLeafSum = new BinaryTreeToLeafSum();
        binaryTreeToLeafSum.printPaths(node, new Stack<>());
    }

    public static int sumTree(Node root, int val){
        if(null == root)
            return 0;

        val = val*10+root.value;

        //If leaf node is reached return val
        if(root.left == null && root.right == null)
            return val;

        return sumTree(root.left,val)+sumTree(root.right,val);
    }

    //Print all paths from root to leaf
    //Either yu can use a deque or a stack
    public void printPaths(Node root, Stack<Integer> path){
        if(null == root)
            return;
        //path.addLast(root.value);
        path.add(root.value);
        //path.add(root.value);

        if(null == root.left && null == root.right){
            System.out.println(path);

        }

        printPaths(root.left,path);
        printPaths(root.right,path);

        path.remove(path.size()-1);
       // path.removeLast();

    }
}
