package GraphAlgorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphTraversalsImpl {
    public static void DFS(int g[][], int v, boolean[] visited) {
        System.out.print(v + " ");
        visited[v] = true;
        for (int i = 0; i < g.length; i++) {
            if (g[v][i] != 0 && !visited[i]) {
                DFS(g, i, visited);
            }
        }
    }

    public static void BFS(int g[][]) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean visited[] = new boolean[g.length];
        visited[0] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            for (int i = 0; i < g.length; i++) {
                if (g[v][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public boolean isBipartite(int[][] graph) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            //Here i indicates the key
            for (int j = 0; j < graph[i].length; j++) {
                int v = graph[i][j];
                addEdge(adjList, i, v);
                addEdge(adjList, v, i);
            }
        }

        HashMap<Integer, Integer> colorMap = new HashMap<>();
        for(int i : adjList.keySet()) {
            colorMap.put(i, -1);
        }
        for (int i : adjList.keySet()) {
            if (colorMap.get(i) == -1) {
                colorMap.put(i,0);
                LinkedList<Integer> queue = new LinkedList<>();
                queue.add(i);
                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    for (int j : adjList.get(u)) {
                        if (colorMap.get(j) == -1) {
                            colorMap.put(j, 1 - colorMap.get(i));
                            queue.add(j);
                        } else if (colorMap.get(j) == colorMap.get(u))
                            return false;
                    }
                }
            }
        }
        return true;
    }
    private static void addEdge(HashMap<Integer, List<Integer>> adjList, int i, int j) {
        if (!adjList.containsKey(i)) {
            adjList.put(i, new LinkedList<>());
        }
        adjList.get(i).add(j);
    }

    public static void main(String[] args) {
        int g[][] = new int[][]{{0, 1, 1, 0, 0, 0},
                {1, 0, 0, 1, 1, 0},
                {1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 1, 1},
                {0, 1, 1, 1, 0, 1},
                {0, 0, 0, 1, 1, 0}};
        System.out.println("DFS");
        DFS(g, 0, new boolean[6]);
        System.out.println();
        System.out.println("BFS");
        BFS(g);


    }

    record QueueEntry (int v, int dist) {}
    static int minThrow(int N, int arr[]){
        // code here
        Map<Integer, Integer> map = getMoves(arr);
        boolean visited[] = new boolean[5*6];
        QueueEntry qe = new QueueEntry(0, 0);
        LinkedList<QueueEntry> queue = new LinkedList<>();
        queue.add(qe);
        visited[0] = true;
        while (!queue.isEmpty()) {
            QueueEntry polled = queue.poll();
            int currPos = polled.v;
            if(currPos == 30) {
                return polled.dist;
            }
            for(int i = currPos+1; i < currPos+1+6; i++) {
                int nextPos = map.getOrDefault(i,i);
                QueueEntry nextQE = new QueueEntry(nextPos, polled.dist+1);
                queue.add(nextQE);
            }
        }
        return -1;
    }

    static Map<Integer, Integer> getMoves(int arr[]) {
        HashMap<Integer, Integer> moves = new HashMap<>();
        for (int i = 0; i < arr.length; i+=2) {
            moves.put(arr[0],arr[1]);
        }
        return moves;
    }
}
