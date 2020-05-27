package src.com.interview.graph;

import java.util.*;

public class TopologicalSortEducative {


    /*
     Input: Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
        Output: Following are the two valid topological sorts for the given graph:
        1) 3, 2, 0, 1
        2) 3, 2, 1, 0
     */
    public static void main(String[] args) {
        List<Integer> result = TopologicalSortEducative.sort(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println(result);

        result = TopologicalSortEducative.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
                new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);
    }


    public static List<Integer> sort(int vertices, int edges[][]){
        List<Integer> sortedOrder = new ArrayList<>();
        if(vertices <= 0)
            return sortedOrder;

        //a> initialize the graph
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < vertices ; i++) {
            inDegree.put(i,0);
            graph.put(i,new ArrayList<>());
        }


        //b> build the graph
        for(int i=0;i<edges.length;i++){
            int parent = edges[i][0];
            int child = edges[i][1];
            graph.get(parent).add(child);
            inDegree.put(child,inDegree.get(child)+1);
        }

        //c>Find all sources i.e. all vertices with 0 in- degree
        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry:inDegree.entrySet()){
            if(entry.getValue() == 0)
                queue.add(entry.getKey());
        }

        //d> for each source add it to the sortedOrder list and substract one from it's children in-degree
        //If a child's indegree becomes 0 add it to sorted list
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

        //e> check if graph doesn't has cycle
        if(sortedOrder.size() != vertices)
            return new ArrayList<>();

        return sortedOrder;

    }

}
