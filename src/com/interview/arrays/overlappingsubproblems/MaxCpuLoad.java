package arrays.overlappingsubproblems;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaxCpuLoad {

    /*
    We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running.
    Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.
    Jobs: [[1,4,3], [2,5,4], [7,9,6]]
    Output: 7
    Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the
    jobs are running at the same time i.e., during the time interval (2,4).
     */

    class Jobs{
        int start;
        int end;
        int job;

        public Jobs(int start, int end, int job){
            this.start = start;
            this.end =end;
            this.job = job;
        }
    }

    public int findMaxCpuLoad(List<Jobs> jobs){
        Collections.sort(jobs, (a,b) -> a.start-b.start);
        PriorityQueue<Jobs> minHeap = new PriorityQueue<>(jobs.size(), (a,b) -> Integer.compare(a.end,b.end));

        int currentCpuLoad = 0;
        int maxCpuLoad = 0;

        for(Jobs job: jobs){
            //Remove all jobs which do not overlap
            while (!minHeap.isEmpty() && job.start > minHeap.peek().end){
                currentCpuLoad -= minHeap.poll().job;
            }
            minHeap.offer(job);
            currentCpuLoad +=job.job;
            maxCpuLoad = Math.max(currentCpuLoad, maxCpuLoad);
        }

        return maxCpuLoad;
    }
    public static void main(String[] args) {

    }
}
