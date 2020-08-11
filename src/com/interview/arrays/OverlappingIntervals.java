package src.com.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappingIntervals {

    /**
     * Given a collection of intervals, merge all overlapping intervals.
     *
     * Example 1:
     * Input: [[2,6],[8,10],[15,18], [1,3]]
     * Output: [ [1,6] , [8,10] , [15,18] ]
     * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6]
     * @param args
     *
     *
     * This is also similar to meeting room problems
     */

    public static void main(String[] args) {
        int[][] intervals =  {
                {2,6},
                {8,10},
                {15,18},
                {1,3}

        };
       Arrays.stream(mergeIntervals(intervals)).forEach(e->{
           System.out.println(e.toString());
       });
    }

    public static int[][] mergeIntervals(int[][] intervals){
        if(intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals,(i1,i2)->Integer.compare(i1[0],i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for(int[] interval: intervals){
            if(interval[0] <= newInterval[1]){
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }else {
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }


}
