package src.com.interview.dp;

public class LongestIncreasingSubsequence {

    /**
     * Given an input of numbers, find the longest increasing subsequece
     * {4,2,3,6,10,1,12}
     * LIS is {2,3,6,10,12}.
     * o/p 5
     * @param args
     */

    public static void main(String[] args) {
        int input[] = {4,2,3,6,10,1,12};
        System.out.println(longestIncreasing(input,0,-1));
    }

    public static int longestIncreasing(int[] nums, int currentIndex, int previousIndex){
        if(nums.length <= 0 || currentIndex == nums.length)
            return 0;

        int c1 =0;
        if(previousIndex == -1 || nums[currentIndex]>=nums[previousIndex]){
            c1 = 1+longestIncreasing(nums,currentIndex+1,currentIndex);
        }

        //excluding the number at the currentIndex
        int c2 = longestIncreasing(nums,currentIndex+1,previousIndex);
        return Math.max(c1,c2);

    }
}
