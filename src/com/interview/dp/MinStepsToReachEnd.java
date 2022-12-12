package dp;

public class MinStepsToReachEnd {

    /*
    Given an array of positive numbers, where each element represents the max number of jumps that can be made forward from that element,
    write a program to find the minimum number of jumps needed to reach the end of the array (starting from the first element).
     If an element is 0, then we cannot move through that element.
    Input = {2,1,1,1,4}
    Output = 3
    Explanation: Starting from index '0', we can reach the last index through: 0->2->3->4
     */
    public static void main(String[] args) {

    }

    public int minJumps(int[] jumps, int currentIndex){
        //If we have reached the end of the array, return 0
        if(currentIndex == jumps.length - 1)
            return 0;
        //cannot jump at currentIndex so return Integer.maxvalue
        if(jumps[currentIndex] == 0){
            return Integer.MAX_VALUE;
        }
        int start = currentIndex+1;
        int end = currentIndex + jumps[currentIndex];
        int totalJumps = Integer.MAX_VALUE;
        while (start < jumps.length && start<=end){
            int minJumps = minJumps(jumps, start++);
            if(minJumps != Integer.MAX_VALUE){
                totalJumps = Math.min(totalJumps, minJumps+1);
            }
        }

        return totalJumps;
    }
}
