package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    int v;
    List<List<Integer>> adjArr;

    public Graph(int v){
        this.v = v;
        this.adjArr = new ArrayList<>();

        for(int i=0;i<v;i++){
            adjArr.add(new ArrayList<>());
        }
    }
    /*
     a --> b
     |      e
     c----d

     arr[]
     1 a
     2b
     c
     d
     e
     */

    public void addEdge(Graph graph, int src, int dest){
        graph.adjArr.get(src).add(dest);

        //Since graph is adirected add destination to src is also required
        graph.adjArr.get(dest).add(src);
    }

    public void printGraph(Graph graph){
        for(int i=0;i<graph.v;i++){
            System.out.println("Adjacency List Head is: " + i);
            System.out.println("Elements are:");
            for (Integer pCrawl: graph.adjArr.get(i)){
                System.out.println("->"+pCrawl);
            }
            System.out.println("\n");
        }
    }
}
