package src.com.interview.Queue;

import java.util.PriorityQueue;

public class ConnectNRopes {

    /**
     * Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope with minimum cost.
     * The cost of connecting two ropes is equal to the sum of their lengths.
     * Input: [1, 3, 11, 5]
     * Output: 33
     * Explanation: First connect 1+3(=4), then 4+5(=9), and then 9+11(=20). So the total cost is 33 (4+9+20)
     */

    public static void main(String[] args) {
        int[] input = new int[] {1, 3, 11, 5};
        connectRopes(input);
    }

    public static void connectRopes(int[] input){
        //As we need to find the minimum cost
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int result=0;
        int temp;
        for (int i=0;i<input.length;i++)
            minHeap.add(input[i]);

        while (minHeap.size()>1){
            temp = minHeap.poll()+minHeap.poll();
            result +=temp;
            minHeap.add(temp);
        }
        System.out.println("Minimum cost is: "+result);

    }

}
