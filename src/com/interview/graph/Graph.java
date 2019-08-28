package src.com.interview.graph;

import java.util.LinkedList;

public class Graph {

    int v;
    LinkedList<Integer> adjArr[];

    public Graph(int v){
        this.v = v;
        this.adjArr = new LinkedList[v];

        for(int i=0;i<v;i++){
            adjArr[i] = new LinkedList<>();
        }
    }

    public void addEdge(Graph graph, int src, int dest){
        graph.adjArr[src].add(dest);

        //Since graph is adirected add destination to src also
        graph.adjArr[dest].add(src);
    }

    public void printGraph(Graph graph){
        for(int i=0;i<graph.v;i++){
            System.out.println("Adjacency List Head is: " + i);
            System.out.println("Elements are:");
            for (Integer pCrawl: graph.adjArr[i]){
                System.out.println("->"+pCrawl);
            }
            System.out.println("\n");
        }
    }
}
