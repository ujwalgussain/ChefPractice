package GraphAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversalsImpl {
    public static void DFS(int g[][], int v,boolean[] visited)
    {
        System.out.print(v + " ");
        visited[v]=true;
        for(int i=0;i<g.length;i++)
        {
            if(g[v][i]!=0 && !visited[i])
            {
                DFS(g,i,visited);
            }
        }
    }
    public static void BFS(int g[][])
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean visited[] = new boolean[g.length];
        visited[0]=true;
        while (!queue.isEmpty())
        {
            int v=queue.poll();
            System.out.print(v+" ");
            for(int i=0;i<g.length;i++)
            {
                if(g[v][i]!=0 && !visited[i])
                {
                    visited[i]=true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int g[][] = new int[][]{{0,1,1,0,0,0},
                {1,0,0,1,1,0},
                {1,0,0,0,1,0},
                {0,1,0,0,1,1},
                {0,1,1,1,0,1},
                {0,0,0,1,1,0}};
        System.out.println("DFS");
        DFS(g,0,new boolean[6]);
        System.out.println();
        System.out.println("BFS");
        BFS(g);


    }
}
