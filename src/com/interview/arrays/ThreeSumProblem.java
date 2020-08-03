package src.com.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumProblem {

    /*
    Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
    Find all unique triplets in the array which gives the sum of zero.

    Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)
    The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},
         A solution set is:
            (-1, 0, 1)
             (-1, -1, 2)
     */

    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSumProblem(nums));
    }

    public static List<List<Integer>> threeSumProblem(int nums[]){
        List<List<Integer>> solutionSet = new ArrayList<List<Integer>>();

        if(nums == null || nums.length < 3)
            return solutionSet;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;

                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        solutionSet.add(list);
                        j++;
                        k--;
                        //Handling duplicates in case j is repeated
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        // Handling duplicates in case k is alo repeated multiple times
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return solutionSet;
    }
}
