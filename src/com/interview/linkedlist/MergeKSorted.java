package linkedlist;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSorted {

    //Merge K sorted linked list

    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public ListNode mergeK(ListNode[] lists){
        if(lists.length == 0)
            return null;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((e1, e2) -> e1.val - e2.val);
        for(int i=0;i<lists.length;i++){
            minHeap.add(lists[i]);
        }

        while (!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            current.next = node;
            current = node;
            if(node.next != null){
                minHeap.add(node.next);
            }
        }
        return dummy.next;
    }
}
