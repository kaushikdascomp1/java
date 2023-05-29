package com.interview.linkedlist;

public class Reverse {

    public static void main(String args[]) {
        LinkedList node = new LinkedList(12);
        node.next = new LinkedList(13);
        node.next.next = new LinkedList(14);
        node.next.next.next = new LinkedList(15);
       // printLL(node);
       // LinkedList head = reverse(node);
        LinkedList head2 = reverseK(node,2);
        printLL(head2);
    }


    public static void printLL(LinkedList node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static LinkedList reverse(LinkedList node) {
        LinkedList curr = node;
        LinkedList prev = null;
        LinkedList next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;

    }


    public static LinkedList reverseK(LinkedList node, int k) {
        LinkedList curr = node;
        LinkedList prev = null;
        LinkedList next = null;
        int count = 0;
        while (count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null) {
            node.next = reverseK(next, k);
        }
        return prev;
    }
}
