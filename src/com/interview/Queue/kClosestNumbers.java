package src.com.interview.Queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class kClosestNumbers {

    /*
    Given a sorted number array and two integers ‘K’ and ‘X’, find ‘K’ closest numbers to ‘X’ in the array.
    Return the numbers in the sorted order. ‘X’ is not necessarily present in the array.

     */

    public static void main(String[] args) {
        int num[] = {2, 4, 5, 6, 9};
        int x = 6;
        int k = 3;
        closest(num,k,x);

        closestBinarySearch(num,k,x);
    }

    //[2, 4, 5, 6, 9] x=6, k=3
    //[4,2,1,0,3]
    //This is a good solution but the complexity is O(n) as you need to traverse the whole array
    //Another way is by using binary search using x
    public static void closest(int[]  num, int k, int x){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1,n2)->n2-n1);
        for(int i=0;i<num.length;i++){
            maxHeap.add(Math.abs(x-num[i]));

            if(maxHeap.size()>k)
                maxHeap.poll();
        }

        while(!maxHeap.isEmpty()){
            System.out.println("Closest Number to X:: "+ (x-maxHeap.poll()));
        }
    }

    //Using Binary Search
    //Complexity of this solution is O(k) Space complexity is O(log(n-k))
    public static void closestBinarySearch(int[] num, int k, int x){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1,n2)->n2-n1);
        int index = Arrays.binarySearch(num, x);

        if(index!=-1){
            int start = index - k;
            int end = index + k;

            //Validate start and end points, if starting index can be less than 0 or end index can be greater than max length
            if(start<0)
                start = 0;

            if(end>=num.length)
                end = num.length;


            for(int i=start;i<end;i++){
                maxHeap.add(Math.abs(x-num[i]));
                if(maxHeap.size()>k)
                    maxHeap.poll();
            }

            while(!maxHeap.isEmpty()){
                System.out.println("Closest Number to X:: "+ (x-maxHeap.poll()));
            }
        }
    }
}
