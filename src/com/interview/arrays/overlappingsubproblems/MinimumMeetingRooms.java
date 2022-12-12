package arrays.overlappingsubproblems;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumMeetingRooms {

    class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    };

    public static int findMinimumMeetingRooms(List<Meeting> intervals){
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        PriorityQueue<Meeting> minHeap = new PriorityQueue<>((a,b) -> a.end - b.end);
        int minRooms = 0;
        for(Meeting meeting: intervals){
            //removing all meetings that have ended
            while(!minHeap.isEmpty() && meeting.start >= minHeap.peek().end){
                minHeap.poll();
            }
            minHeap.offer(meeting);
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }

    //without using priorityqueue
    public static int minimum(List<Meeting> intervals){
        if(intervals.size() <= 2){
            return 1;
        }

        Collections.sort(intervals, (e1, e2)->e1.start - e2.start);
        int count = 1;
        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i).start < intervals.get(i-1).end){
                count++;
            }
        }
        return count;
    }
}
