package GraphAlgorithms.detectCycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindRedundantEdge {
    /*
    https://leetcode.com/problems/redundant-connection/
    Before adding an edge u,v
    We should check if there exists a path from v to u
    If yes then adding u to v will create a cycle
    Else add the Edge u,v
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[][] graph = new int[n + 1][n + 1];
        for (int[] edge :
                edges) {
            int u = edge[0];
            int v = edge[1];
            //System.out.println(u+" " + v + " " + graph[u][v]);
            if (hasPathFromUToV(graph, n, u, v, new boolean[n + 1]))
                return edge;//redundantEdge  Ex: 1-2, 1-3 then 2-3 will be redundant Edge as 2 is Reachable from 3 via 2->1->3
            //Add u to v
            graph[u][v] = 1;
            //Add v to u
            graph[v][u] = 1;
        }
        return new int[2];
    }

    public boolean hasPathFromUToV(int[][] graph, int n, int src, int curr, boolean[] visited) {
        //System.out.println("Graph : "+ src +" " + curr + " " + graph[src][curr]);
        visited[curr] = true;
        if (src == curr)
            return true;
        if (graph[curr][src] == 1)
            return true;
        for (int neighbor = 1; neighbor <= n; neighbor++) {
            if (!visited[neighbor] && graph[curr][neighbor] == 1) {
                if (hasPathFromUToV(graph, n, src, neighbor, visited))
                    return true;
            }
        }
        return false;
    }
}
