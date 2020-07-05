package src.com.interview.dp;

import src.com.interview.trees.model.Node;

public class HouseRobberTree {

    /*
        The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house.
        After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
        Determine the maximum amount of money the thief can rob tonight without alerting the police.
     */

    public static void main(String[] args) {

    }

    public static int findMaxRecursive(Node root){
        if(null == root)
            return -1;
        int val = 0;
        //Eitheryou select the root node or you don't
        //If you select the root node then the next set of values you can select is root.left.left and root.left.right
        if(root.left!=null){
            val +=findMaxRecursive(root.left.left)+findMaxRecursive(root.left.right);
        }

        if(root.right != null){
            val +=findMaxRecursive(root.right.left)+findMaxRecursive(root.right.right);
        }
        //if you don't select the root value then the next set of values you can select if root.left and root.right
        return Math.max(val+root.value,findMaxRecursive(root.left)+findMaxRecursive(root.right));
    }
}
