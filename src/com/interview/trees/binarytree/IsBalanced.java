package src.com.interview.trees.binarytree;

import src.com.interview.trees.model.Node;

public class IsBalanced {

    public static void main(String[] args) {

    }

    //Time complexity is O(n^2)
    public boolean isBalanced(Node root) {
        if (null == root)
            return false;
        int lh = height(root.left);
        int rh = height(root.right);
        //Traverse for each and every node in a binary tree
        return (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right));
    }

    public int height(Node root) {
        if (null == root)
            return -1;
        int lheight = height(root.left);
        int rheight = height(root.right);
        if (lheight > rheight)
            return lheight + 1;
        return rheight + 1;
    }

    class height{
        int height = 0;
    }

    //isbalanced check for O(n)
}
