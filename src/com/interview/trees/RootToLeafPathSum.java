package src.com.interview.trees;

import src.com.interview.trees.model.Node;

public class RootToLeafPathSum {

    //To check the sum of all paths from root to leaf node
    //summation till left subtree and summation till right sub tree
    public int rootToLeafPathSum(Node root, int val){
        if(null != root){
            val = val*10+root.value;
            //return val if it has reached the leaf node
            if(root.left == null && root.right == null)
                return val;
            return rootToLeafPathSum(root.left,val)+rootToLeafPathSum(root.right,val);
        }
        return 0;
    }

    //Check if path exists for a sum from root to leaf
    public boolean isSum(Node root, int sum){
        if(null == root)
            return sum == 0;
        return (isSum(root.left,sum-root.value) || isSum(root.right,sum-root.value));
    }
}
