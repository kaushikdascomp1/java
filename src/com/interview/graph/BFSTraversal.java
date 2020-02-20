package src.com.interview.graph;

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
        graphDirected.dfs(2);
    }


}
