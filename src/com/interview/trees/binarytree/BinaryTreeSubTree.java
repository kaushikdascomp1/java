package src.com.interview.trees.binarytree;

import src.com.interview.trees.model.Node;

import java.util.HashSet;

public class BinaryTreeSubTree {

    /*
    Check if a binary tree is subtree of another tree
    https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/

    https://www.geeksforgeeks.org/serialize-deserialize-binary-tree/
     */

    public static void main(String[] args) {
        Node root = new Node('A');
        root.left = new Node('B');
        root.right = new Node('C');
        root.left.left = new Node('D');
        root.left.right = new Node('E');
        root.right.right = new Node('B');
        root.right.right.right = new Node('E');
        root.right.right.left= new Node('D');
        String str = treeHash(root,new HashSet<>());

        if(str.equalsIgnoreCase(""))
            System.out.println("Subtree Exists:: Yes");
        else
            System.out.println("No");
    }


    //Complexity of the above solution is O(mn) where m nodes in main tree and n nodes in subtree
    //Here we need to check if for every other node is there any subtree present for the main tree
    boolean isSubTree(Node tree, Node subTree){
        //If subtree is null then return true as subtree can be null
        if(null == subTree)
            return true;
        //But if main tree is nul then return false as main tree cannot be null
        if(null == tree)
            return false;

        if(areIdentical(tree,subTree))
            return true;
        return isSubTree(tree.left,subTree) || isSubTree(tree.right,subTree);
    }

    public static boolean areIdentical(Node root1, Node root2){
        if(null == root1 || null == root2)
            return false;

        if(null == root1 && null == root2)
            return true;

        return (root1.value == root2.value) && areIdentical(root1.left,root2.left) && areIdentical(root1.right,root2.right);
    }

    //A better and efficient solution is using Tree serialization and hashing
    //With this approach with the same tree itself you can check. No need of two tree(Main and subtree) where iteration of every other node is required in the previous example
    static char marker = '$';
    public static String treeHash(Node root, HashSet<String> subtrees){
       //For null nodes either mark as -1 or with any other character
        String s = "";
        if(null == root)
            return s+marker;

        String lStr = treeHash(root.left,subtrees);
        if(lStr.equals(s))
            return s;

        String rStr = treeHash(root.right,subtrees);
        if(rStr.equals(s))
            return s;

        //Serialize current Subtree
        s = s + root.value + lStr + rStr;

        //Check if length of s > 3 as Left,right and root should be -1/$. Here we are checking with 4 as ASCII of A is 65 which is 2 character
        if(s.length() > 4 && subtrees.contains(s))
            return "";

        subtrees.add(s);
        return s;
    }
}
