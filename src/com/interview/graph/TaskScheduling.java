package src.com.interview.graph;

import java.util.*;

public class TaskScheduling {

    /**
     * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be completed before it can be scheduled.
     * Given the number of tasks and a list of prerequisite pairs, find out if it is possible to schedule all the tasks.
     */

    public static void main(String[] args) {
        boolean result = TaskScheduling.isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println("Tasks execution possible: " + result);
    }

    public static boolean isSchedulingPossible(int vertices, int edges[][]){
        List<Integer> sortedOrder = new ArrayList<>();
        if(vertices <= 0)
            return false;

        //a>Initialize graph
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=0;i<vertices;i++){
            inDegree.put(i,0);
            graph.put(i,new ArrayList<>());
        }

        //b>Build the graph with the edges
        for(int i=0;i<edges.length;i++){
            int parent = edges[i][0];
            int child = edges[i][1];
            graph.get(parent).add(child);
            inDegree.put(child,inDegree.get(child)+1);
        }

        //c>Find all sources with 0 in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer,Integer> entry:inDegree.entrySet()){
            if(entry.getValue() == 0)
                queue.add(entry.getKey());
        }

        //d> for each value in queue add it to the soretd order list
        // get all childrens for each source and substract the indegree -1
        //if indegree is 0 add it to the queue
        while (!queue.isEmpty()){
            int vertex = queue.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex);
            for(Integer child:children){
                inDegree.put(child,inDegree.get(child)-1);
                if(inDegree.get(child) == 0)
                    queue.add(child);
            }
        }

        return sortedOrder.size() == vertices;

    }

}
