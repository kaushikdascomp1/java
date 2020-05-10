package src.com.interview.trees.model;

public class Node {

    public int value;
    public Node left;
    public Node right;

    public Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void insert(Node root, int key){
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
