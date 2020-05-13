package src.com.interview.trees.binarytree;

import src.com.interview.trees.model.Node;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class LeftViewRightView {

    public static void main(String[] args) {

    }


    int max_level = 0;
    public void printLeftView(Node root, int level){
        if(null == root)
            return;
        if(max_level < level){
            max_level = level;
            System.out.println(root.value);
        }else {
            printLeftView(root.left,level+1);
            printLeftView(root.right,level+1);
        }
    }


    public void printRightView(Node root, int level){
        if (null == root)
            return;
        if(max_level < level){
            max_level = level;
            System.out.println(root.value);
        }else {
            printRightView(root.right,level+1);
            printRightView(root.left,level+1);
        }

    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        int hd;

        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
            this.hd = 0;
        }
    }

    public void printBottomView(TreeNode root){
        if(root == null)
            return;
        //A map to store the key vaue pairs in sorted order
        //Key is vertical distance and value is data
        Map<Integer, Integer> map = new TreeMap<>();

        //Queue to store nodes in level order traversal
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            map.put(temp.hd,temp.val);

            if(temp.left!=null){
                temp.left.hd -= 1;
                queue.add(temp.left);
            }

            if(temp.right!=null){
                temp.right.hd +=1;
                queue.add(temp.right);
            }

        }

        map.entrySet().stream().forEach(e->{
            System.out.println("Vertical distance is:  "+e.getKey()+"   Val:: "+e.getValue());
        });

    }
}
