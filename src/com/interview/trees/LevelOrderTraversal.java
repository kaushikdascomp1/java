package src.com.interview.trees;

import src.com.interview.trees.model.Node;

public class LevelOrderTraversal {

    public static void main(String[] args) {

        LevelOrderTraversal level = new LevelOrderTraversal();
        Node node = new Node(50);
        level.insert(node, 30);
        level.insert(node, 20);
        level.insert(node, 40);
        level.insert(node, 70);
        level.insert(node, 60);
        level.insert(node, 80);
        int height = level.height(node);

        for (int i=1;i<=height;i++){
            level.levelOrder(node,i);
        }

        //for spiral form
        boolean flag = true;
        for (int i=1;i<=height;i++){
            level.spiralLevelOrder(node,i,flag);
            flag = !flag;
        }

    }

    private void levelOrder(Node root, int level){
        if(null == root)
            return;
        if(level == 1)
            System.out.println("Level Order Traversal::  "+root.value);
        else {
            levelOrder(root.left,level-1);
            levelOrder(root.right,level-1);
        }
    }

    private void spiralLevelOrder(Node root, int level, boolean flag){
        if(null == root)
            return;
        if(level == 1)
            System.out.println("Level Order Traversal::  "+root.value);
        else if(level > 1) {
            if(flag){
                spiralLevelOrder(root.left,level-1,flag);
                spiralLevelOrder(root.right,level-1,flag);
            }else {
                spiralLevelOrder(root.right,level-1,flag);
                spiralLevelOrder(root.left,level-1,flag);
            }

        }
    }

    private int height(Node root){
        if(null == root)
            return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);

        if(lheight > rheight)
            return lheight+1;
        return rheight+1;
    }

    private void insert(Node root, int key){
        if(null == root)
            return;
        if(key < root.value){
            if(null == root.left){
                root.left = new Node(key);
            }else {
                insert(root.left,key);
            }
        }else if(key > root.value){
            if(null == root.right){
                root.right = new Node(key);
            }else {
                insert(root.right,key);
            }
        }
    }

}
