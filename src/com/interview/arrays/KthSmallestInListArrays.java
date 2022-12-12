package arrays;

import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestInListArrays {

    /*
        Find the Kth smallest number in a list of arrays
        Given ‘M’ sorted arrays, find the K’th smallest number among all the arrays.
        Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4], K=5
        Output: 4

        Brute force scenario would be O(N log M) where N is the length of the arrays but as we need only K
        Complexity: O(K log M) where M is the number of arrays
     */

    public static void main(String[] args) {

    }

    class Node{
        int arrayIndex;
        int elementIndex;

        public Node(int arrayIndex, int elementIndex){
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
    }
    public int kthSmallest(List<Integer[]> list, int k){
        //Elements added in the PQ are the actual elements, because we add the node but it will take from the lists
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) ->
                list.get(n1.arrayIndex)[n1.elementIndex] - list.get(n2.arrayIndex)[n2.elementIndex]);

       //Adding the first element of each element in the list
       for(int i=0;i<list.size();i++){
           minHeap.add(new Node(i, 0));
       }

       //Take the smallest top element from the heap, if the running count is equal to K return
        //If the array of top element has more elements add it to the heap
        int numCount = 0;
       int result = 0;
        while (!minHeap.isEmpty()){
            Node node = minHeap.poll();
            result = list.get(node.arrayIndex)[node.elementIndex];
            if(++numCount == k){
                break;
            }
            node.elementIndex++;
            if(list.get(node.arrayIndex).length > node.elementIndex){
                minHeap.add(node);
            }
        }
        return result;

    }
}
