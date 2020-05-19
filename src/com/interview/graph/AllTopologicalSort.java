package src.com.interview.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AllTopologicalSort {

    int val;
    LinkedList<Integer> adjArr[];

    public AllTopologicalSort(int val){
        this.val = val;
        this.adjArr = new LinkedList[val];

        for (int i = 0; i < val; i++) {
            adjArr[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest){
        this.adjArr[src].add(dest);
    }

    /*
    graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);




     */

    public void allTopology(){
        boolean visited[] = new boolean[this.val];
        int indegree[] = new int[this.val];

        for(int i=0;i<this.val;i++){
            for (int var:this.adjArr[i]){
                indegree[var]++;
            }
        }

        List<Integer> stack = new ArrayList<>();
        //call recursive alltopologicalsortutil

        allTopologicalSortUtil(visited,indegree,stack);
    }

    /*
        5-> 2, 0
        4 -> 0,1
        3->1
        2->3
        1->
        0->

        Indegree:
        5 -> 0
        4-> 0
        3-> 1
        2-> 1
        1-> 2
        0-> 2
     */
    public void allTopologicalSortUtil(boolean visited[], int indegree[], List<Integer> stack){
        boolean flag = false;
        for(int i=0;i<this.val;i++){
            if(!visited[i] && indegree[i] == 0){
                visited[i] = true;
                stack.add(i);

                for(int adjacent:this.adjArr[i])
                    indegree[adjacent]--;
                allTopologicalSortUtil(visited,indegree,stack);

                //algo for removing the indegree node = 0 and recalculating again
                visited[i] = false;
                stack.remove(stack.size()-1);
                for (int adjacent:this.adjArr[i])
                    indegree[adjacent]++;
                flag = true;
            }
        }
        if(!flag){
            stack.forEach(i->System.out.print(i + " "));
            System.out.println();
        }

    }

    public static void main(String[] args) {
        AllTopologicalSort graph = new AllTopologicalSort(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.allTopology();
    }
}
