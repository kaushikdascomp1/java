package arrays.overlappingsubproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class InsertIntervals {

    /*
    Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the correct position
    and merge all necessary intervals to produce a list that has only mutually exclusive intervals.
    Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
    Output: [[1,3], [4,7], [8,12]]

    Complexity- O(nlog n)
    If the intervals are not sorted by their start time, then we can insert the interval, sort it by their start time
    and then merge these intervals
     */

    class Interval{
        int start;
        int end;

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    //If the question doesn't mention about the intervals being sorted then we vcan just add and sort
    // the intervals and then merge it but as it is mentioned that the intervals are sorted we should come up with
    //better approach than O(nlogn)
    //[[1,4], [2,6], [3,5]]
    public List<Interval> insertInterval(List<Interval> intervals, Interval newInterval){
        //base conditions
        if(intervals.size() < 2){
            return intervals;
        }
        List<Interval> mergedIntervals = new ArrayList<>();
        intervals.add(newInterval);
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        Iterator<Interval> itr = intervals.iterator();
        Interval inter = itr.next();
        int start = inter.start;
        int end = inter.end;

        while(itr.hasNext()){
            Interval interval = itr.next();
            if(interval.start <= end){
                end = Math.max(interval.end, end);
            }else {
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        //adding the last interval as start and end have the last changes
        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
    }

    //Complexity with inserting the new Interval after finding the correct position to insert the new interval
    // O(n) as we would be iterating the interval list only once
    //Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
    // For merging, it should be minimum of both the start points and end should be maximum of both ends
    public List<Interval> insertIntervalOne(List<Interval> intervals, Interval newInterval){
        //base conditions
        if(intervals.size() < 2){
            return intervals;
        }
        List<Interval> mergedIntervals = new ArrayList<>();
        int i=0;
        //iterating over the list of intervals to see if interval.end < newInterval.start i.e non overlapping intervals
        while(i < intervals.size() && intervals.get(i).end < newInterval.start){
            mergedIntervals.add(intervals.get(i++));
        }

        //merge all intervals that overlap with newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }

        mergedIntervals.add(newInterval);
        //add all remaining intervals
        while(i < intervals.size()){
            mergedIntervals.add(intervals.get(i++));
        }
        return mergedIntervals;
    }
}
