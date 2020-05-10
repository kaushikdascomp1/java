package src.com.interview.trees;

import src.com.interview.trees.model.Node;

import java.util.Stack;

public class InOrderIterative {

    public static void main(String[] args) {
        InOrderIterative iterative = new InOrderIterative();
        Node node = new Node(50);
        node.insert(node, 30);
        node.insert(node, 20);
        node.insert(node, 40);
        node.insert(node, 70);
        node.insert(node, 60);
        node.insert(node, 80);
        iterative.iterative(node);
    }

    private void iterative(Node root){
        if(null == root)
            return;
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()){
                while (curr != null){
                    stack.push(curr);
                    curr = curr.left;
                }
            //print the root
            curr = stack.pop();
            System.out.println("Value is: "+curr.value);
            //Traverse the right sub tree
            curr=curr.right;
        }
    }
}
