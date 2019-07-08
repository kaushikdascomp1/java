package src.com.interview.trees;

import src.com.interview.trees.model.Node;

public class LowestCommonAncestor {

    public static void main(String args[]) {
        Node node = new Node(50);
        Node root = node;
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.insertValue(node, 30);
        tree.insertValue(node, 20);
        tree.insertValue(node, 40);
        tree.insertValue(node, 70);
        tree.insertValue(node, 60);
        tree.insertValue(node, 80);
        tree.printTree(root);
        findLca(root, 20, 40);

    }

    public static void findLca(Node root, int a, int b) {
        if (null == root)
            return;
        if (a < root.value && b < root.value) {
            findLca(root.left, a, b);
        } else if (a > root.value && b > root.value) {
            findLca(root.right, a, b);
        } else {
            System.out.println("LCA is: " + root.value);
        }
    }


    public void printTree(Node root) {
        if (null == root)
            return;
        printTree(root.left);
        System.out.println(root.value);
        printTree(root.right);

    }


    public void insertValue(Node root, int key) {
        if (null == root)
            return;
        if (key < root.value) {
            if (root.left == null) {
                root.left = new Node(key);
            } else {
                insertValue(root.left, key);
            }

        } else if (key > root.value) {
            if (root.right == null) {
                root.right = new Node(key);
            } else {
                insertValue(root.right, key);
            }
        }

    }

}
