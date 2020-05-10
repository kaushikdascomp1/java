package src.com.interview.trees.binarytree;

import src.com.interview.trees.model.Node;

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

    public void printTopView(){

    }
}
