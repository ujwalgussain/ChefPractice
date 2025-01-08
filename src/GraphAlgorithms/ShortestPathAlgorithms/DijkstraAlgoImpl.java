package GraphAlgorithms.ShortestPathAlgorithms;

import java.util.Arrays;
import java.util.HashSet;

/*
 * S1: Create a mstSet{} and CostMtx initialized to Inf {INF,INF,....}
 * S2: Start with 0th node. Add O to mstSet{0} and costmtx[0]=0
 * S3:Relax all neighbours ie., dist[u]+cost[u,v]
 * S4: Select minCost node which is not present in mstSet
 * S5: Perform S3 to S5 until all nodes are visited*/
public class DijkstraAlgoImpl {

    static void relax(int[][] g, int[] costmtx, HashSet<Integer> mstSet, int currNode) {
        for (int i = 0; i < g.length; i++) {
            if (!mstSet.contains(i)) {
                if(g[currNode][i] != I){
                    int cost = costmtx[currNode] + g[currNode][i];
                    if (cost < costmtx[i]) {
                        costmtx[i] = cost;
                    }
                }
            }
        }
    }

    public static int findMinCostNode(int[] costmtx, HashSet<Integer> mstSet) {
        int minCostNode = -1, mincost = Integer.MAX_VALUE;
        for (int i = 0; i < costmtx.length; i++) {
            if (!mstSet.contains(i) && mincost > costmtx[i]) {
                minCostNode = i;
                mincost = costmtx[i];
            }
        }
        return minCostNode;
    }

    public static void Dijsktra(int[][] g, int[] costmtx, HashSet<Integer> mstSet, int currNode) {
        //System.out.println(currNode);
        if (mstSet.size() == g.length)
            return;
        //Relax all neighbours of curr node & select min cost node
        relax(g, costmtx, mstSet, currNode);

        //System.out.print(Arrays.toString(costmtx));
        //add mincostneighbour to
        int minCostNode = findMinCostNode(costmtx, mstSet);

        System.out.println(" minCostNode ->" + minCostNode);
        mstSet.add(minCostNode);
        Dijsktra(g, costmtx, mstSet, minCostNode);
    }

    public static int I = Integer.MAX_VALUE;

    public static void main(String[] args) {

        int g[][] = new int[][]{
                {I, 2, 4, I, I, I},
                {I, I, 1, 7, I, I},
                {I, I, I, I, 3, I},
                {I, I, I, I, I, 1},
                {I, I, I, I, I, 5},
                {I, I, I, I, I, I}
        };
        HashSet<Integer> mstSet = new HashSet<>();
        mstSet.add(0);
        int[] costmtx = new int[6];
        Arrays.fill(costmtx, I);
        costmtx[0] = 0;

        Dijsktra(g, costmtx, mstSet, 0);
       /* {
            int mincostneighbour=-1, mincost=Integer.MAX_VALUE;
            while(mstSet.size()<g.length)
            {
                for(int i=0;i<costmtx.length;i++)
                {
                    if(!mstSet.contains(i) && mincost>costmtx[i])
                    {
                        mincostneighbour=i;
                        mincost=costmtx[i];
                    }
                }
            }
            System.out.println("neigh "+mincostneighbour);
            mstSet.add(mincostneighbour);
            //Relax all neighbours
            int currNode=mincostneighbour;
            for(int i=0;i<g.length;i++)
            {
                if(!mstSet.contains(i))
                {
                    int cost = costmtx[currNode]+g[currNode][i];
                    if(cost<costmtx[i]) {
                        costmtx[i] = cost;
                    }
                }
            }
        }*/
    }

}
