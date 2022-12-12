package arrays.overlappingsubproblems;

import java.util.Arrays;
import java.util.Objects;

public class ConflictingAppointments {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval: ["+start + ","+end+"]";
        }
    }
    /*
    Given an array of intervals representing ‘N’ appointments,
    find out if a person can attend all the appointments.
    Appointments: [[1,4], [2,5], [7,9]]
    Output: false
    Overall time complexity is O(nlogn) as for sorting the TC is O(nlogn)
     */
    public boolean canAttend(Interval[] intervals){
        if(intervals.length < 2){
            return true;
        }

        Arrays.sort(intervals, (a, b) -> a.start-b.start);
        for(int i=1;i<intervals.length;i++){
            if(intervals[i].start < intervals[i-1].end){
                return false;
            }
        }
        return true;
    }

    public static Interval[] findConflict(Interval[] intervals){
        if(intervals.length < 2){
            return intervals;
        }

        Interval[] mergedInterval = new Interval[intervals.length];
        int j = 0;
        for(int i=1;i< intervals.length;i++){
            if(intervals[i].start < intervals[i-1].end){
                mergedInterval[j++] = intervals[i];
                mergedInterval[j++] = intervals[i-1];
            }
        }

        return mergedInterval;
    }

    public static void main(String[] args) {
        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        Interval[] conflicts = findConflict(intervals);
        Arrays.stream(conflicts).filter(Objects::nonNull).forEach(e -> {
            System.out.println("Conflict: ["+e.start+","+e.end+"]");
        });
        System.out.println();
    }

}
