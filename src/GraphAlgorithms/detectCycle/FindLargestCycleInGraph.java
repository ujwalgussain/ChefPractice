package GraphAlgorithms.detectCycle;

import java.util.List;

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

}
