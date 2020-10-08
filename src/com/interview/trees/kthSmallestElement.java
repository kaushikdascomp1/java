package src.com.interview.trees;

import src.com.interview.trees.model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class kthSmallestElement {

    public static void main(String[] args) {
        kthSmallestElement kthSmallestElement = new kthSmallestElement();

        Node node = new Node(50);
        node.insert(node, 30);
        node.insert(node, 20);
        node.insert(node, 40);
        node.insert(node, 70);
        node.insert(node, 60);
        node.insert(node, 80);
        Node kthSmallest = kthSmallestElement.kthSmallest(node, 4);
        System.out.println("4rd Smallest is:: "+kthSmallest.value);

        int kthSmallestVal = kthSmallestElement.kthSmallestInOrder(node, 4);
        System.out.println("4th Smallest Value:: Using InOrder:: "+kthSmallestVal);
    }

    public Node kthSmallest(Node root, int k){
        Node curr = root;
        Node result = null;
        Stack<Node> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            Node t = stack.pop();
            k--;
            if(k == 0){
                result = t;
                return result;
            }

            curr = t.right;
        }
        return result;
    }

    //kth Smallest can also be found out using inorder Traversal and then providing the array index at (k-1) index
    //Additional space complexity of O(n) to store the elements inOrder
    public int kthSmallestInOrder(Node root, int k){
        List<Integer> inOrderList = inOrder(root);
        return inOrderList.get(k-1);
    }

    List<Integer> inOrderValues = new ArrayList<>();
    public List<Integer> inOrder(Node root){
        if(null == root)
            return null;
        inOrder(root.left);
        inOrderValues.add(root.value);
        inOrder(root.right);

        return inOrderValues;
    }

}
