package GraphAlgorithms.detectCycle;

import java.util.List;
import java.util.Map;

public class FindLargestCycleInGraph {

    private static int largestCycle = 0;
    static void dfsUndirectedGraph(int node, int parent, List<List<Integer>> graph, boolean[] visited, List<Integer> path) {
        visited[node] = true;
        path.add(node);

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfsUndirectedGraph(neighbor, node, graph, visited, path);
            } else if (neighbor != parent) {
                // Found a cycle
                int index = path.indexOf(neighbor);
                int cycleLength = path.size() - index;
                largestCycle = Math.max(largestCycle, cycleLength);
            }
        }

        path.remove(path.size() - 1);
    }


    static void dfsDirectedGraph(int node, List<List<Integer>> graph, boolean[] visited, boolean[] onStack, List<Integer> path) {
        visited[node] = true;
        onStack[node] = true;
        path.add(node);

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfsDirectedGraph(neighbor, graph, visited, onStack, path);
            } else if (onStack[neighbor]) {
                // Found a cycle
                int index = path.indexOf(neighbor);
                int cycleLength = path.size() - index;
                largestCycle = Math.max(largestCycle, cycleLength);
            }
        }

        onStack[node] = false;
        path.remove(path.size() - 1);
    }

    //0->unvisited
    //1->processed
    //2->under process
    public int solveDirectedGraph(Map<Integer, List<Integer>> adjList, int u, int d, int color[], int[] depth) {
        int largest = 0;
        depth[u] = d;
        color[u] = 2; // mark under process
        for (int v : adjList.getOrDefault(u, List.of())) {
            if (color[v] == 2) { // under process
                largest = Math.max(largest, d - depth[v] + 1);
            }
            if (color[v] == 0) { //unvisited.
                largest = Math.max(largest, solveDirectedGraph(adjList, v, d + 1, color, depth));
            }

        }
        color[u] = 1;
        return largest;

        /*
        Ex A -> B -> C -> D -> E
                     ^---------|
           depth  A(0) -> B(1) -> C(2) -> D(3) -> E(4) -> calls solve(c)
                    depth(E) - depth(C) + 1 = 4-2+1 = 3;
         */
    }

}
