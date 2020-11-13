package src.com.interview.trees.binarytree;

import src.com.interview.trees.model.Node;

public class MirrorBinaryTree {

    /*
        Given a binary tree, convert the tree to a mirror binary tree
        Given the root node of a binary tree, swap the ‘left’ and ‘right’ children for each node. The below example shows how the mirrored binary tree should look like.
     */

    public static void main(String[] args) {
        Node root = new Node(40);
        root.left = new Node(100);
        root.right = new Node(400);

        root.left.left = new Node(150);
        root.left.right = new Node(50);

        root.right.left = new Node(300);
        root.right.right = new Node(600);

        int height = height(root);

        for(int i=1;i<=height;i++){
            levelOrder(root,i);
        }

        //Converting to mirror Tree
        System.out.println("Start Converting to mirror image");

        convertToMirror(root);
        for(int i=1;i<=height;i++){
            levelOrder(root,i);
        }

    }

    public static void convertToMirror(Node root){
        if(null == root)
            return;

        if(root.left != null && root.right != null){
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;

        }else if(root.left != null){
            root.right = root.left;
        }else if(root.right != null)
            root.left = root.right;

        convertToMirror(root.left);
        convertToMirror(root.right);
    }

    //Print tree using level order traversal
        public static int height(Node root){
            if(null == root)
                return 0;
            int lheight = height(root.left);
            int rheight = height(root.right);

            if(lheight > rheight)
                return lheight+1;
            return rheight+1;
        }


        public static void levelOrder(Node root, int level){
            if(null == root)
                return;

            if(level == 1)
                System.out.println(root.value + " ");
            else {
                levelOrder(root.left, level-1);
                levelOrder(root.right, level-1);
            }
        }
}
