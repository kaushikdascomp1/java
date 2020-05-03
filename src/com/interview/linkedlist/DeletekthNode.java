package src.com.interview.linkedlist;

public class DeletekthNode {

    public static void main(String[] args) {

    }

    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static void deletekthNode(Node head, int k){
        if(null == head)
            return;
        if(k == 1)
            head = freeNode(head);

        Node curr = head; Node prev  = null;
        int count = 0;
        while (curr != null){
            count++;
            if(count == k){
                prev.next = curr.next;
                count = 0;
            }else{
                prev = curr;
            }

            curr = prev.next;
        }

    }

    static Node freeNode(Node node){
        while (node != null){
            Node next = node.next;
            node = next;
        }
        return node;

    }
}
