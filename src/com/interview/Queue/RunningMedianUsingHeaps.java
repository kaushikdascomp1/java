package src.com.interview.Queue;

import java.util.PriorityQueue;

public class RunningMedianUsingHeaps {

    /*
    Find the running median in a stream
    Stream of numbers are there and always it should return you the median at any point of time

    Median -  Is the mid point of a sorted array
    If size of array is odd then median is the mid
    If size of the array is even then median is mid-1 + mid+1 /2

    Design a class to calculate the median of a number stream. The class should have the following two methods:

        insertNum(int num): stores the number in the class
        findMedian(): returns the median of all numbers inserted in the class
     */

    // 1,2,3,4   5        6,7,8,9,10
    //In this case 5 is the median, so we maintain a maxheap on left side(All smaller numbers) and a minheap of all larger numbers(right side)
    //So when we do maxheap.peek and minheap.peek() it will return the median

    public static void main(String[] args) {
        RunningMedianUsingHeaps runningMedianUsingHeaps = new RunningMedianUsingHeaps();
        runningMedianUsingHeaps.insertNum(3);
        runningMedianUsingHeaps.insertNum(1);

        System.out.println("Median till now:: "+runningMedianUsingHeaps.findMedian());
        runningMedianUsingHeaps.insertNum(5);
        System.out.println("Median till now:: "+runningMedianUsingHeaps.findMedian());
        runningMedianUsingHeaps.insertNum(4);
        System.out.println("Median till now:: "+runningMedianUsingHeaps.findMedian());
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1,n2)->n2-n1);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void insertNum(int num){
        if (maxHeap.isEmpty() || num <= maxHeap.peek() )
            maxHeap.add(num);
        else
            minHeap.add(num);

        //Rebalance the heap after inserting
        if (maxHeap.size() > minHeap.size() + 1)
        minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    // Due to the rebalnce maxheap will have 1 element more than minheap so we return from maxheap
    public double findMedian(){
        if(maxHeap.size() == minHeap.size())
            return (maxHeap.peek()  + minHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
    }
}
