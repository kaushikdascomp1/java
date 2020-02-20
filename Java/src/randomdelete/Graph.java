package Java.src.randomdelete;


import java.util.LinkedList;

public class Graph {

    int v;
    LinkedList<Integer> adjArr[];

    public Graph(int v){
        this.v = v;
        this.adjArr = new LinkedList[v];
        for(int i=0;i<v;i++){
            adjArr[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(Graph graph, int src, int dest){
        graph.adjArr[src].add(dest);

        // As this is a adirected graph so need to add dest to src as well
        graph.adjArr[dest].add(src);
    }

    public void printGraph(Graph graph){
        for(int i=0;i<graph.v;i++){
            System.out.println("Adjacency List Head are: "+i);
            System.out.println("Elements are: ->" );
            for(Integer pCrawl:graph.adjArr[i]){
                System.out.println("Child elements  ->"+pCrawl);
            }
        }
    }
}
