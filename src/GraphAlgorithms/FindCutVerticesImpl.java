package GraphAlgorithms;

import java.util.Arrays;
import java.util.Scanner;
/*
* Articulation Point: (https://www.youtube.com/watch?v=jFZsDDB0-vo)
*   S1: Prepare a DFS Spanning Tree and no the nodes according to their discovery
*   S2: Find lowest D for Each node in the tree.
*       If(low[v]>=d[u]) then u is articulation pt.
*       This is not applicable to root. For root if DFS spanning tree has 2 or more nodes then root is articulation pt
* */
public class FindCutVerticesImpl {
    static int num=1;
    static int[][] g;
    static int time=0;
    static int[] dfs_num,low;
    static int NIL=-1;
    static void findCutVertex(int u)
    {
       // System.out.printf("CV(%s)\n",(char)(u+'A'));
       // System.out.println("dfs_num="+Arrays.toString(dfs_num)+" low="+Arrays.toString(low));
        low[u]=num;
        dfs_num[u]=num;
        num++;
        int cnt=0;
        for(int i=0;i<g.length;i++)
        {
            if(g[u][i]==1)
            {
                if(dfs_num[i]==-1)
                {
                    findCutVertex(i);
                    cnt++;
                    //System.out.printf("for u =%s low[v=%s]=%d dfs[u=%s]=%d\n",(char)(u+'A'),(char)(i+'A'),low[i],(char)(u+'A'),dfs_num[u]);
                    low[u]=Math.min(low[u],low[i]);
                    if(u!=0 && low[i]>=dfs_num[u])
                    {
                        System.out.println("Cut Vertex"+((char)(u+'A')) );
                    }
                    if(u==0 && cnt>1){
                        System.out.println("Cut Vertex"+((char)(u+'A')) );
                    }

                }
                else
                {
                    low[u]=Math.min(low[u],dfs_num[i]);
                }
            }
        }
    }

    static void APUtil(int u, boolean visited[], int disc[],
                int low[], int parent[], boolean ap[])
    {

        // Count of children in DFS Tree
        int children = 0;

        // Mark the current node as visited
        visited[u] = true;

        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;

        // Go through all vertices aadjacent to this
        for(int v=0;v<g.length;v++)
        {
            if(g[u][v]!=0)
            {
                if (!visited[v])
                {
                    children++;
                    parent[v] = u;
                    APUtil(v, visited, disc, low, parent, ap);

                    // Check if the subtree rooted with v has a connection to
                    // one of the ancestors of u
                    low[u]  = Math.min(low[u], low[v]);

                    // u is an articulation point in following cases

                    // (1) u is root of DFS tree and has two or more chilren.
                    if (parent[u] == NIL && children > 1)
                        ap[u] = true;

                    // (2) If u is not root and low value of one of its child
                    // is more than discovery value of u.
                    if (parent[u] != NIL && low[v] >= disc[u])
                        ap[u] = true;
                }

                // Update low value of u for parent function calls.
                else if (v != parent[u])
                    low[u]  = Math.min(low[u], disc[v]);
            }
        }
    }

    // The function to do DFS traversal. It uses recursive function APUtil()
    static void AP()
    {
        // Mark all the vertices as not visited
        int V = g.length;
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];
        boolean ap[] = new boolean[V]; // To store articulation points

        // Initialize parent and visited, and ap(articulation point)
        // arrays
        for (int i = 0; i < V; i++)
        {
            parent[i] = -1;
            visited[i] = false;
            ap[i] = false;
        }

        // Call the recursive helper function to find articulation
        // points in DFS tree rooted with vertex 'i'
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                APUtil(i, visited, disc, low, parent, ap);

        // Now ap[] contains articulation points, print them
        for (int i = 0; i < V; i++)
            if (ap[i] == true)
                System.out.print(((char)(i+'A'))+" ");
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
        Arrays.fill(dfs_num,-1);
        /*for(int[] a:g)
            System.out.println(Arrays.toString(a));*/
        findCutVertex(0);
        AP();
    }
}
/*
* 7 8
A B
B C
A D
C D
C G
D F
D E
E F*/