package GraphAlgorithms.findunconnectednodes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NumberOfOperationsToMakeNetworkConnected {
    //https://leetcode.com/problems/number-of-operations-to-make-network-connected/
    /*
    So if we have n nodes then we will need atleast n-1 nodes to make fully connected graph.
    Hence if no of distinctEdge < n-1 then we cant make the graph fully connected
    So we can find the no of unconnected nodes, we will need unconnected nodes -1 edges to be changed
     */
    public int makeConnected(int n, int[][] connections) {
        boolean visited[] = new boolean[n];
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        int distinctEdges = 0;
        for(int i=0;i<connections.length;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            boolean added = addEdge(graph,u,v);
            addEdge(graph,v,u);
            distinctEdges+=added?1:0;
        }
        if(distinctEdges<n-1)// we cant connect n nodes without atleast n-1 connections.
            return -1;
        int c = 0;

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                /*DFS will mark all reachable nodes as visited. If any unvisited node found in next iteration will be disjoint*/
                c++;
                dfs(graph, visited,i);
            }
        }
        return c-1;
    }

    /*Return True if we added a distinct Edge*/
    boolean addEdge(HashMap<Integer, Set<Integer>> graph, int u, int v){
        if(graph.containsKey(u)){
            return graph.get(u).add(v);
        }
        Set<Integer> set = new HashSet<>();
        set.add(v);
        graph.put(u,set);
        return true;
    }


    void dfs(HashMap<Integer, Set<Integer>> graph, boolean[] visited, int u){
        visited[u] = true;
        for (Integer neighbor:graph.getOrDefault(u,new HashSet<>())) {
            if(!visited[neighbor])
                dfs(graph, visited, neighbor);
        }
    }
}
