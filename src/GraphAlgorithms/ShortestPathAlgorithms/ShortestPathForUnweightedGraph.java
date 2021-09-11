package GraphAlgorithms.ShortestPathAlgorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathForUnweightedGraph {
    public void BFS(int G[][], int V)
    {
        int distance[] = new int[V];
        int path[] = new int[V];

        Arrays.fill(distance,-1);
        distance[0] = 0;

        Queue<Integer> queue = new LinkedList();
        queue.add(0);

        while(!queue.isEmpty())
        {
            int curr = queue.poll();

            for(int i=0;i<V;i++)
            {
                if(G[curr][i]!=0 && distance[i]!=-1)
                {
                    distance[i] = distance[curr] + 1;
                    path[i] = curr;
                    queue.add(i);
                }
            }
        }

    }
}
