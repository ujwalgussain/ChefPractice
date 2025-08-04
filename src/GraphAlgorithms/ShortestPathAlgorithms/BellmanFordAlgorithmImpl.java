package GraphAlgorithms.ShortestPathAlgorithms;

import java.util.Arrays;

/*Reference: https://www.youtube.com/watch?v=FtN3BYH2Zes
            https://cp-algorithms.com/graph/bellman_ford.html
It uses the Dynamic Programming Approach
    For each Edge we need to relax it V-1 times
    Repeat for V-1 times
        relax:
        if(d[u]+G[u][v]<d[v])
        {
            d[v]=d[u]+G[u][v];
            parent[v]=u;
        }

    Time Complexity:
    O(|E| * |V|-1) -> O(|E| * |V|-1) if V = E = n then O(n^2)
    for Complete Graph having n(n-1)/2 edges and n vertices the TC would be O(n^3)

    Drawbacks:
    1. Time Complexity:
        It may happen that After some iterations any node is not relaxed but we still keep continuing until V-1 Iterations
        Hence TC can be improved by checking whether any node is relaxed in a iteration. If no then stop.
    2. Doesn't work if there is a negative weight cycle:
        Eg:
                4
            1--------X2
            |       / X
            |      /  |
          5 |   5 /   | -10
            |    /    |
            |   /     |
            |  /      |
            X X       |
             4-------X3
                3
      Here 2,3,4 forms a negative weight cycle.
      5+3-10=-2 will always reduce after each iteration.
      So How can we check whether a graph has negative weight cycle?
      Ans: After V-1 iterations, if any of the node is relaxing the -ve cycle exists
* */
public class BellmanFordAlgorithmImpl {
    int[] d;
    int[] parent;
    int[][] G;
    int V;
    static final int INFINITY = Integer.MAX_VALUE;

    void initialize(int[][] G) {
        this.G = G;
        V = G.length;
        d = new int[V];
        parent = new int[V];
        Arrays.fill(d, INFINITY);
        d[0] = 0;
        parent[0] = -1;
    }

    void applyBellmanFordAlgo(int[][] G) {
        /*Repeat the following V-1 times
            For Each Edge u,v
                Relax(u,v)
        * */
        initialize(G);
        for (int i = 0; i < V - 1; i++) {
            boolean isRelaxed = false; // Improves the Time Complexity
            for (int u = 0; u < V; u++) {
                for (int v = 0; v < V; v++) {
                    if (G[u][v] != INFINITY) //for each valid edge
                    {
                        //Relax
                        if (d[u] !=INFINITY //Very Imp. in case of disconnected graph
                                && d[u] + G[u][v] < d[v]) {
                            d[v] = d[u] + G[u][v];
                            parent[v] = u;
                            isRelaxed = true;
                        }
                    }
                }
            }
            if (!isRelaxed) {
                if (i < V - 1)
                    System.out.println("isOptimized");
                break;
            }
        }
        System.out.println("Distance " + Arrays.toString(d));
        System.out.println("parent " + Arrays.toString(parent));

    }

    public static void main(String[] args) {
        BellmanFordAlgorithmImpl obj = new BellmanFordAlgorithmImpl();
        int i = INFINITY;
        int[][] G = new int[][]
                {
                        {i, 6, 5, 5, i, i, i},
                        {i, i, i, i, -1, i, i},
                        {i, -2, i, i, 1, i, i},
                        {i, i, -2, i, i, -1, i},
                        {i, i, i, i, i, i, 3},
                        {i, i, i, i, i, i, 3},
                        {i, i, i, i, i, i, i}
                };
        obj.applyBellmanFordAlgo(G);

        /*Negative weight cycle*/
        System.out.println("Negative Weights Cycle ");
        G = new int[][]
                {
                        {i, 4, i, 5},
                        {i, i, i, 5},
                        {i, -10, i, i},
                        {i, i, 3, i}
                };
        obj.applyBellmanFordAlgo(G);
    }

    boolean hasNegWeightCycle(int[][] G) {
        // A negative weight cycle will relax even after V - 1 iterations.
        initialize(G);
        for (int i = 0; i < V - 1; i++) {
            boolean isRelaxed = false; // Improves the Time Complexity
            for (int u = 0; u < V; u++) {
                for (int v = 0; v < V; v++) {
                    if (G[u][v] != INFINITY) //for each valid edge
                    {
                        //Relax
                        if (d[u] + G[u][v] < d[v]) {
                            d[v] = d[u] + G[u][v];
                            parent[v] = u;
                            isRelaxed = true;
                        }
                    }
                }
            }
            if (!isRelaxed) {
                //already relaxed, hence no negative weight cycle present.
                return false;
            }
        }

        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                if (G[u][v] != INFINITY) //for each valid edge
                {
                    if (d[u] + G[u][v] < d[v]) {
                        //Relaxing even after V-1 attempts.
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
