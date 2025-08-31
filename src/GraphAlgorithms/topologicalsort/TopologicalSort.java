package GraphAlgorithms.topologicalsort;

import GraphAlgorithms.AdjacencyMatrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

/*
Reference: https://www.youtube.com/watch?v=ddTC4Zovtbc&list=PLrmLmBdmIlpu2f2g8ltqaaCZiq6GJvl1j
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for
every directed edge uv, vertex u comes before v in the ordering.
Topological Sorting for a graph is not possible if the graph is not a DAG.
Note: Topological Sorting is not applicable for Cyclic Graphs.

Here the approach is to use 2 DS:
    1. Visted Set: Marks all visited vertices
    2. Stack: Which contains the elements in sorted order

We start with any random vertex, and check following:
    1. Add the vertex to Visited set and
        if vertices has unvisted neigbours
            repeat this step for the neighbours
        Else
            if no neigbours/unvisted neigbours then put the vertex in the stack
    2. If after exploring all the vertices from step 1 there are still some unvisited nodes
        choose any random vertex repeat step1 for the same.

        5        4
      /  \      / \
     /    \    /   \
    X      X  X     X
   2        0       1
    \               X
     \             /
      \           /
       \         /
        \       /
         \     /
          \   /
           X /
            3

Current Visited      Stack           Description
0       0           0               No neighbours...hence add to stack
1       1           0,1             No neighbours...hence add to stack
2       2           0,1             Go to 3
2->3    3           0,1,3           No neighbours...hence add to stack
2       -           0,1,3,2         All neighbours visted...hence add to stack
4       4           0,1,3,2,4       No neighbours...hence add to stack
5       5           0,1,3,2,4,5     No neighbours...hence add to stack

Topological Sort ->5 4 2 3 1 0
*/
public class TopologicalSort {
    static void topologicalSort(int[][] G, int V) {
        //V-> no of vertices
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (visited[i])
                continue;
            // System.out.println("Calling ");
            topologicalSort_Util(G, V, i, visited, stack);
        }
        System.out.print("Topological Sort ->");
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    static void topologicalSort_Util(int[][] G, int V, int current_vertex, boolean visited[], Stack<Integer> stack) {
        /*This method ensures a node is added to stack in following cases:
            1. If node doesnt have any neighbours
            2. If all neighbours are explored
        * */
        visited[current_vertex] = true;
        for (int i = 0; i < V; i++) {
            if (G[current_vertex][i] == 1) {
                    if (!visited[i]) {
                        topologicalSort_Util(G, V, i, visited, stack);
                    }
            }
        }
        stack.push(current_vertex);
    }

    public static void main(String[] args) {
        AdjacencyMatrix g = new AdjacencyMatrix(6, true);
        g.addEdge(5, 0);
        g.addEdge(5, 2);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        topologicalSort(g.getAdjMatrix(), g.getV());
    }

}
