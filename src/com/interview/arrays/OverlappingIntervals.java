package com.interview.arrays;

import java.util.*;

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

        int[][] overlaps = mergeIntervals(intervals);
        for(int[] over:overlaps){
            for(int st:over){
                System.out.print(st+" ");
            }
            System.out.println();
        }
    }

    public List<Interval> overlapping(List<Interval> intervals){
        if(intervals.size() < 2){
            return intervals;
        }

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        Iterator<Interval> itr = intervals.iterator();
        Interval interval = itr.next();
        int start = interval.start;
        int end = interval.end;

        while(itr.hasNext()){
            interval = itr.next();
            if(interval.start <= end){
                //when there is overlapping interval
                end = Math.max(end, interval.end);
            }else{
                //add interval to list for non-verlapping
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        //adding last interval
        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
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

   //Insert an INterval and merge as well
    public class Interval{
        int start;
        int end;

        public Interval(){
            this.start = 0;
            this.end = 0;
        }

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
   }

   public ArrayList<Interval> insertInterval(List<Interval> intervals, Interval newInterval){
        intervals.sort((i1,i2)->i1.start-i2.start);

        ArrayList<Interval> result = new ArrayList<>();
        for(Interval interval: intervals){
            if(interval.end < newInterval.start)
                result.add(interval);
            else if(interval.start > newInterval.end){
                result.add(newInterval);
                newInterval = interval;
            }else if(interval.end >= newInterval.start || interval.start <= newInterval.end){
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
            }
        }

        result.add(newInterval);
        return result;
   }

    //Meeting room problem 2:
    /*
    Check whether a person can attend all meetings
    Given an array of meeting time intervals consisting of
    start and end times [[s1,e1],[s2,e2],...] (si <ei),
    determine if a person could attend all meetings. For
    example, Given [[0, 30],[5, 10],[15, 20]], return false.
        Java Solution
     */

    // A person can attend all meetings if current end is < next start
    // if(interval[i].end>interval[i+1].start) then return false

}
