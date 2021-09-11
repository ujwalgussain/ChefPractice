package GraphAlgorithms;

import java.util.*;

public class CheckIfPathExists {
    public static boolean checkWithDFS(int[][] G, boolean visited[], int V, int src, int tgt) {
        if (src == tgt)
            return true;
        for (int v = 0; v < V; v++) {
            if (G[src][v] == 1 && !visited[v]) {
                visited[src] = true;
                boolean ans = checkWithDFS(G, visited, V, v, tgt);
                if (ans)
                    return ans;
            }
        }
        return false;
    }

    public static boolean checkWithBFS(int[][] G, boolean visited[], int V, int src, int tgt) {
        if (src == tgt)
            return true;
        LinkedList<Integer> queue = new LinkedList();
        queue.push(src);
        visited[src] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v = 0; v < V; v++) {
                if(G[u][v]==1 && !visited[v])
                {
                    if(v==tgt)
                        return true;
                    visited[v]=true;
                    queue.push(v);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /*
            0--1--2--3
        * */
        int[][] G1 = new int[][]{{0, 1, 0, 0}, {1, 0, 1, 0}, {1, 0, 0, 1}, {0, 0, 1, 0}};
        System.out.println(checkWithDFS(G1, new boolean[4], 4, 0, 3));
        System.out.println(checkWithBFS(G1, new boolean[4], 4, 0, 3));

        /*
            0--1 2--3
        * */
        int[][] G2 = new int[][]{{0, 1, 0, 0}, {1, 0, 0, 0}, {0, 0, 0, 1}, {0, 0, 1, 0}};
        System.out.println(checkWithDFS(G2, new boolean[4], 4, 0, 3));
        System.out.println(checkWithBFS(G2, new boolean[4], 4, 0, 3));
    }
}
