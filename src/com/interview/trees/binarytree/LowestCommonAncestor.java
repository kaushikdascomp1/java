package src.com.interview.trees.binarytree;

import src.com.interview.trees.model.Node;

public class LowestCommonAncestor {

    public static void main(String[] args) {

    }

    static boolean v1 = false;
    static boolean v2 = false;
    public static Node findLca(Node root, int a, int b){
        Node lcaUtil = findLcaUtil(root, a, b);
        if(v1 && v2){
                return lcaUtil;
            }
            return null;
    }

    public static Node findLcaUtil(Node root, int n1, int n2){
        if(null == root)
            return null;
        if(root.value == n1){
            v1 = true;
            return root;
        }

        if(root.value == n2){
            v2 = true;
            return root;
        }

        Node leftLca = findLcaUtil(root.left,n1,n2);
        Node rightLca = findLcaUtil(root.right,n1,n2);

        //if both the left lca and right lca is not null return node
        if(null != leftLca && null != rightLca){
            return root;
        }

        //else if one of them is not null which means both the keys are either present on left side or right side return the left or the right lca
        return leftLca != null ? leftLca : rightLca;


    }
}
