package src.com.interview.graph;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class GraphDirected {

    int v;
    List<List<Integer>> ajdArray;

    public GraphDirected(int v){
        this.v = v;
        this.ajdArray = new ArrayList<>();

        for(int i=0;i<v;i++){
            ajdArray.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest){
        //As this is an directed graph, we only add the edges what is required
        //Not like an adirected graph where every node has a connection with each other
        ajdArray.get(src).add(dest);
    }

    public void bfs(int start){
        boolean[] visited = new boolean[v];

        Queue<Integer> queue = new LinkedBlockingQueue<>();
        visited[start]=true;
        queue.add(start);

        while(!queue.isEmpty()){
            start = queue.poll();
            System.out.println(" " +start + " ");
            Iterator<Integer> iterator = ajdArray.get(start).listIterator();

            while (iterator.hasNext()){
                int n = iterator.next();

                if(visited[n] == false){
                    visited[n] = true;
                    queue.add(n);
                }

            }
        }

    }

    /**
     * This can also be used to find the complete path between the source and the destinaton
     *
     * @param start
     */

    public boolean dfs(int start,  Stack<Integer> path){
        boolean visited[] = new boolean[v];
        return dfsUtil(start,visited, path);
    }

    public boolean dfsUtil(int start, boolean visited[], Stack<Integer> path){

        visited[start] = true;
        System.out.println(" " + start);
        path.add(start);
        Iterator<Integer> iterator = ajdArray.get(start).listIterator();

        while (iterator.hasNext()){
            int n = iterator.next();
            if(visited[n]==false)
               if( dfsUtil(n,visited,path))
                   return true;

        }

        path.pop();
        return false;
    }


    public void printGraph(GraphDirected graph){
        for(int i=0;i<graph.v;i++){
            System.out.println("Adjacency List Head is: " + i);
            System.out.println("Elements are:");
            for (Integer pCrawl: graph.ajdArray.get(i)){
                System.out.println("->"+pCrawl);
            }
            System.out.println("\n");
        }
    }
}
