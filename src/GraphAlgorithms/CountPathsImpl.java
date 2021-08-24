package GraphAlgorithms;

import java.util.Stack;

public class CountPathsImpl {
    static int cnt=0;
    public static void countPaths(int[][] g, int currnode, int destnode, boolean[] vis)
    {
        if(currnode==destnode)
            cnt++;
        else
        {
            vis[currnode]=true;
            for(int i=0;i<g.length;i++)
            {
                if(g[currnode][i]!=0 && !vis[i])
                {
                    countPaths(g,i,destnode,vis);
                }
            }
            vis[currnode]=false;
        }
    }
    public void countPaths(int[][] g, int s, int d)
    {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[g.length];
        stack.push(s);
        visited[s]=true;
        int count=0;
        while(!stack.isEmpty())
        {
            int v = stack.pop();
            for(int i=0;i<g.length;i++)
            {
                if(i==d)
                {
                    count++;
                    visited[i] = false;
                }
                if(!visited[i] && g[v][i]!=0)
                {
                    visited[i] = true;
                    stack.push(i);
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
        countPaths(g,0,3,new boolean[6]);
        System.out.println(cnt);
    }
}
