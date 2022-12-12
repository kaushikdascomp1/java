package src.com.interview.trees;

import src.com.interview.trees.model.Node;

public class IsBST {

    public static void main(String[] args) {
        Node root = new Node(4);
        insert(root,2);
        insert(root,5);
        insert(root,1);
        insert(root,3);
        /*insert(root,20);
        insert(root,80);
        insert(root,10);
        insert(root,100);*/

        Node root1 = new Node(4);
        root1.left     = new Node(2);
        root1.right     = new Node(5);
        root1.left.left = new Node(1);
        root1.left.right = new Node(3);
        printTree(root1);
        System.out.println(checkBST(root));
    }

    public static Node prev = null;

    public static boolean checkBST(Node root){
        if(null != root){
            if(checkBST(root.left))
                return true;
            if(null != prev && prev.value >= root.value)
                return false;
            prev = root;
            if(checkBST(root.right))
                return true;
        }

        return true;
    }

    //check bst tree using min max

    public static boolean checkBstMinMax(Node root){
        boolean check = checkBSTMinMaxUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return check;
    }
    public static boolean checkBSTMinMaxUtil(Node root, int min, int max){
        if(null == root)
            return false;
        // Maximum value in the left sub tree is smaller and smallest vale in the right sub tree is greater than root
        if( root.value > max || root.value < min)
            return false;
        //check left and right sub tree
        return (checkBSTMinMaxUtil(root.left,min,root.value-1) && checkBSTMinMaxUtil(root.right,root.value+1,max));
    }

    public static void printTree(Node root){
        if (null == root)
            return;
        printTree(root.left);
        System.out.println(root.value);
        printTree(root.right);
    }

    public static void insert(Node root, int key){
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
