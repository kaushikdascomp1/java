package src.com.interview.trees;

import src.com.interview.trees.model.Node;

public class SearchInBST {

    public static void main(String[] args) {

    }

    static class GenericNode<T> {
        T val;
        GenericNode<T> left;
        GenericNode<T> right;

        public GenericNode(T val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public Node searchTree(Node root, int key) {
        if (null == root || root.value == key)
            return root;

        else if (key < root.value)
            return searchTree(root.left, key);
        else
            return searchTree(root.right, key);
    }

    public Node searchKeyIterative(Node root, int key){
        while (null != root){

            if(key<root.value)
                root = root.left;
            else if (key>root.value)
                root = root.right;
            else
                return root;
        }
        return null;
    }
}
