package com.interview.arrays.overlappingsubproblems;

import com.interview.arrays.OverlappingIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IntervalListIntersection {

//Given two list of Intervals, find the intersection of these two interval lists

    public List<OverlappingIntervals.Interval> mergeIntervals(List<OverlappingIntervals.Interval> intervalsa, List<OverlappingIntervals.Interval> intervalsb){
        if(null == intervalsa || null == intervalsb || intervalsa.size() == 0 || intervalsb.size() == 0){
            return new ArrayList<>();
        }

        int i = 0;
        int j = 0;
        Collections.sort(intervalsa, (a, b)->a.start - b.start);
        Collections.sort(intervalsb, (a, b)->a.start - b.start);
        List<OverlappingIntervals.Interval> output = new ArrayList<>();

        while(i<intervalsa.size() && j<intervalsb.size()){
            int start = Math.max(intervalsa.get(i).start, intervalsb.get(i).start);
            int end = Math.min(intervalsa.get(i).end, intervalsb.get(i).end );
            output.add(new OverlappingIntervals.Interval(start, end));
            //if intervala end is less than intervalsb then i++
            if(intervalsa.get(i).end < intervalsb.get(i).end){
                i++;
            }else {
                j++;
            }
        }
        return output;
    }
}
