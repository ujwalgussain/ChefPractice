package GraphAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class FindCutVerticesImpl {
    static int num=1;
    static int[][] g;
    static int[] dfs_num,low;
    static void findCutVertex(int u)
    {
       // System.out.printf("CV(%s)\n",(char)(u+'A'));
       // System.out.println("dfs_num="+Arrays.toString(dfs_num)+" low="+Arrays.toString(low));
        low[u]=num;
        dfs_num[u]=num;
        num++;
        for(int i=0;i<g.length;i++)
        {
            if(g[u][i]==1)
            {
                if(dfs_num[i]==0)
                {
                    findCutVertex(i);
                    //System.out.printf("for u =%s low[v=%s]=%d dfs[u=%s]=%d\n",(char)(u+'A'),(char)(i+'A'),low[i],(char)(u+'A'),dfs_num[u]);
                    if(low[i]>=dfs_num[u])
                    {
                        System.out.println("Cut Vertex"+((char)(u+'A')) );
                    }
                    low[u]=Math.min(low[u],low[i]);
                }
                else
                {
                    low[u]=Math.min(low[u],dfs_num[i]);
                }
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        g=new int[N][N];
        dfs_num=new int[N];
        low = new int[N];
        int m = sc.nextInt();
        while(--m>=0)
        {
            int u = sc.next().charAt(0)-'A';
            int v = sc.next().charAt(0)-'A';
            g[u][v]=1;
            g[v][u]=1;
        }
        for(int[] a:g)
            System.out.println(Arrays.toString(a));
        findCutVertex(0);
    }
}
