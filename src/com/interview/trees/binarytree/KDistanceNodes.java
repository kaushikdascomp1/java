package src.com.interview.trees.binarytree;

import src.com.interview.trees.model.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class KDistanceNodes {

    Map<Node, Integer> map = new HashMap<>();

    public List<Integer> distanceK(Node root, Node target, int K) {
        List<Integer> res = new LinkedList<>();
        find(root, target);
        dfs(root, target, K, map.get(root), res);
        return res;
    }

    // find target node first and store the distance in that path that we could use it later directly
    private int find(Node root, Node target) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }

    private void dfs(Node root, Node target, int K, int length, List<Integer> res) {
        if (root == null) return;
        if (map.containsKey(root)) length = map.get(root);
        if (length == K) res.add(root.value);
        dfs(root.left, target, K, length + 1, res);
        dfs(root.right, target, K, length + 1, res);
    }

    public static void main(String[] args) {
        Node node = new Node(50);
        node.insert(node, 30);
        node.insert(node, 20);
        node.insert(node, 40);
        node.insert(node, 70);
        node.insert(node, 60);
        node.insert(node, 80);
        KDistanceNodes kDistanceNodes = new KDistanceNodes();
        List<Integer> list = kDistanceNodes.distanceK(node, new Node(20), 2);
        System.out.println(list);

    }
}
