package GraphAlgorithms.detectCycle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DetectCycleInDirectedGraph {
    int WHITE = -1; //unvisited
    int BLACK = 0; //visited itself and all neighbors
    int GRAY = 1; //visited itself but neighbors are still unprocessed.

    /*
    detectCycle(graph)
    1. Initially all nodes are marked white.

    2. Iterate over all nodes
        If node is white
            perform dfs(node) and if true return true
    3. return false

    dfs(node)
    1. mark node as gray
    2. Iterate over all neighbors
        If neighbor is gray -> backedge
            then return true;
        Else if neighbor is black
            then continue
        Else if neighbor is white and dfs(neighbor) is true
            return true -> backedge was detected for the neighbor
    3. mark node as black
    4. return false

    Note for printing cycle we will need parent map..at each dfs put(neighbor->parent)
     */

    public boolean isCyclic(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < B.size(); i++) {

            /*graph.compute(B.get(i), (key, value) -> {
                if (value == null)
                    value = new ArrayList<>();
                value.add(C.get(i));
                return value;
            });*/
            if(graph.containsKey(B.get(i)))
                graph.get(B.get(i)).add(C.get(i));
            else{
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(C.get(i));
                graph.put(B.get(i),ans);
            }
        }
        int color[] = new int[A+1];
        Arrays.fill(color, WHITE);
        for (int i = 1; i <= A; i++) {
            if(color[i]== WHITE)
            {
                if(dfs(graph,i,color))
                    return true;
            }
        }
        return false;

    }

    public boolean dfs(
            HashMap<Integer, List<Integer>> adjList,
            int node,
            int[] color
    ) {
        //mark node as visited but not all neighbors are visited.
        color[node] = GRAY;
        if(adjList.get(node) != null)
        {
            for(Integer neighbor: adjList.get(node))
            {
                //back edge
                if(color[neighbor] == GRAY)
                    return true;
                //If neighbor is unvisited, perform dfs
                if(color[neighbor] == WHITE && dfs(adjList, neighbor, color))
                    return true;
            }
        }
        //mark node as visited and all neighbors are visited, so no cycle from the node.
        color[node] = BLACK;
        return false;
    }


    //----------------------- Solution 2 -----------------------
    //https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int a[]:
                edges) {
            adjList.computeIfAbsent(a[0], k -> new ArrayList<>()).add(a[1]);
            //adjList.computeIfAbsent(a[1], k -> new ArrayList<>()).add(a[0]);
        }
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<V; i++) {
            if(dfs(i, adjList, visited)) {
                return true;
            }
        }
        return false;
    }
    boolean dfs(int curr, Map<Integer, List<Integer>> adjList,Set<Integer> visited) {
        if(visited.contains(curr)) {
            return true;
        }
        visited.add(curr);
        for (int v:
                adjList.getOrDefault(curr, new ArrayList<>())) {
            if(dfs(v,adjList,visited)) {
                return true;
            }
        }
        visited.remove(curr);
        return false;
    }

}
