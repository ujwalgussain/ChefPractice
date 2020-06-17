package GraphAlgorithms;

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
