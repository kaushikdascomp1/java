package src.com.interview.graph;

import java.util.Stack;

public class BFSTraversal {

    public static void main(String[] args) {
        GraphDirected graphDirected = new GraphDirected(4);
        /**
         *  0 ---> 1
         *  ||
         *  ||
         *  2-- > 3
         */
        graphDirected.addEdge(0,1);
        graphDirected.addEdge(0,2);

        graphDirected.addEdge(1,2);
        graphDirected.addEdge(2,0);
        graphDirected.addEdge(2,3);
        graphDirected.addEdge(3,3);

       // graphDirected.bfs(2);
        //Check if there exists a path
        Stack<Integer> path = new Stack<>();
        if(graphDirected.dfs(2, path))
            System.out.println("Path Exists and Path is::  "+path);
        else
            System.out.println("Path doesn't exist:: ");
        //o/p returns path doesn't exist
        GraphDirected graphDirected1 = new GraphDirected(8);
        graphDirected1.addEdge(0,3);
        graphDirected1.addEdge(1,0);
        graphDirected1.addEdge(1,2);
        graphDirected1.addEdge(1,4);
        graphDirected1.addEdge(2,7);
        graphDirected1.addEdge(3,4);
        graphDirected1.addEdge(3,5);
        graphDirected1.addEdge(4,3);
        graphDirected1.addEdge(4,6);
        graphDirected1.addEdge(5,6);
        graphDirected1.addEdge(6,7);

        Stack<Integer> path1 = new Stack<>();
        if(graphDirected1.dfs(0, path1))
            System.out.println("Path Exists and Path is::  "+path1);
        else
            System.out.println("Path doesn't exist:: ");

        graphDirected.printGraph(graphDirected);
    }


}
