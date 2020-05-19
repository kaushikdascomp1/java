package src.com.interview.graph;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

    /**
     * Topological sort is slightly different than DFS
     * In TS, we traverse all vertices of the node first and then the node
     * But in DFS only one of them is sufficient
     * In DFS, we print a vertex and then recursively call DFS for its adjacent vertices.
     * In topological sorting, we need to print a vertex before its adjacent vertices
     *
     */
        int v;
        LinkedList<Integer> adjArr[];

    public static void main(String[] args) {
        TopologicalSort top = new TopologicalSort(6);
        top.addEdge(top,2,3);
        top.addEdge(top,3,1);
        top.addEdge(top,4,0);
        top.addEdge(top,4,1);
        top.addEdge(top,5,0);
        top.addEdge(top,5,2);

        top.topologicalSort(6);

    }

    public TopologicalSort(int v){
        this.v = v;
        this.adjArr = new LinkedList[v];

        for(int i=0;i<v;i++)
            adjArr[i] = new LinkedList<Integer>();
    }

    public void addEdge(TopologicalSort top, int src, int dest){
        top.adjArr[src].add(dest);
    }

    public void topoLogicalSortUtil(Stack<Integer> stack, boolean visited[],int v){
        visited[v] = true;

        Iterator<Integer> iterator = adjArr[v].listIterator();
        while (iterator.hasNext()){
            int n = iterator.next();
            if(!visited[n])
                topoLogicalSortUtil(stack,visited,n);
        }
        stack.push(v);
    }

    public void topologicalSort(int v){
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[v];



        for (int i = 0; i <v ; i++) {
            if(visited[i] == false)
                topoLogicalSortUtil(stack,visited,i);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

}
