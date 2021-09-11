package GraphAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CloneGraph {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return test(node, new HashMap<Integer,UndirectedGraphNode>());
    }

    public UndirectedGraphNode test(
            UndirectedGraphNode org_node, HashMap<Integer,UndirectedGraphNode> nodes)
    {
       if(nodes.containsKey(org_node.label))
           return nodes.get(org_node.label);
       UndirectedGraphNode copy_node = new UndirectedGraphNode(org_node.label);
       nodes.put(org_node.label, copy_node);
       for(UndirectedGraphNode neighbor: org_node.neighbors)
           copy_node.neighbors.add(test(neighbor,nodes));
       return copy_node;
    }
}
