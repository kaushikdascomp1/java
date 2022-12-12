package linkedlist;

public class MiddleElement {

    /**
     * To find the middle element of the LL
     * https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
     * @param args
     */

    public static void main(String[] args) {
        LinkedList root = new LinkedList(5);
        root.next = new LinkedList(4);
        root.next.next = new LinkedList(3);
        root.next.next.next = new LinkedList(2);
        root.next.next.next.next = new LinkedList(1);
        System.out.println(middleElement(root).value);

    }

    public static LinkedList middleElement(LinkedList root){
        LinkedList fast = root;
        LinkedList slow = root;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }
}
