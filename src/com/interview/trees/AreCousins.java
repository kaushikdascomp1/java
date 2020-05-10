package src.com.interview.trees;

import src.com.interview.trees.model.Node;

public class AreCousins {

    public static void main(String[] args) {

    }

    private boolean isSibling(Node root, int a, int b){
        return ((root.left.value == a && root.right.value == b) || (root.left.value == b && root.right.value == a) || isSibling(root.left,a,b) || (isSibling(root.right,a,b)));
    }

    private boolean isCousin(Node root, Node a, Node b){
        return ((height(root,a,1) == height(root,b,1) && !isSibling(root,a.value,b.value)));
    }

    private int height(Node root, Node ptr, int level){
        if(null == root)
            return -1;

        if(root == ptr)
            return level;
        int lheight = height(root.left,ptr,level+1);
        if(lheight != 0)
            return lheight;
        int rheight = height(root.right,ptr,level+1);

        return rheight;
    }
}
