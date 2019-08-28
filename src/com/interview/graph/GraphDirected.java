package src.com.interview.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class GraphDirected {

    int v;
    LinkedList<Integer> ajdArray[];

    public GraphDirected(int v){
        this.v = v;
        this.ajdArray = new LinkedList[v];

        for(int i=0;i<v;i++){
            ajdArray[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest){
        //As this is an directed graph, we only add the edges what is required
        //Not like an adirected graph where every node has a connection with each other
        ajdArray[src].add(dest);
    }

    public void bfs(int start){
        boolean[] visited = new boolean[v];

        Queue<Integer> queue = new LinkedBlockingQueue<>();
        visited[start]=true;
        queue.add(start);

        while(!queue.isEmpty()){
            start = queue.poll();
            System.out.println(" " +start + " ");
            Iterator<Integer> iterator = ajdArray[start].listIterator();

            while (iterator.hasNext()){
                int n = iterator.next();

                if(visited[n] == false){
                    visited[n] = true;
                    queue.add(n);
                }

            }
        }

    }


    public void dfs(int start){
        boolean visited[] = new boolean[v];
        dfsUtil(start,visited);
    }

    public void dfsUtil(int start, boolean visited[]){

        visited[start] = true;
        System.out.println(" " + start);
        Iterator<Integer> iterator = ajdArray[start].listIterator();

        while (iterator.hasNext()){
            int n = iterator.next();
            if(visited[n]==false)
                dfsUtil(n,visited);

        }
    }
}
