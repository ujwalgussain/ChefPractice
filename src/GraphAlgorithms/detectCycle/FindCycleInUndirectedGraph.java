package GraphAlgorithms.detectCycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindCycleInUndirectedGraph {
    //https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
    boolean hasCycle(HashMap<Integer, Set<Integer>> graph){
        HashSet<Integer> visited = new HashSet<>();
        for (Integer node:
             graph.keySet()) {
            if(!visited.contains(node)){
                if(hasCycleUtil(graph,visited,-1,node))
                    return true;
            }
        }
        return false;
    }

    boolean hasCycleUtil(HashMap<Integer, Set<Integer>> graph, HashSet<Integer> visitedSet, int parent, int curr){
        visitedSet.add(curr);
        for (Integer neighbor:
             graph.getOrDefault(curr,new HashSet<>())) {
            if(visitedSet.contains(neighbor)){
                if(parent!=neighbor)
                    return true;
            } else {
                if(hasCycleUtil(graph,visitedSet,curr,neighbor)){
                    return true;
                }
            }
        }
        return false;
    }

}
