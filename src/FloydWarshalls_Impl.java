import java.util.Arrays;
import java.util.Scanner;

public class FloydWarshalls_Impl {
    //https://www.youtube.com/watch?v=oNI0rf2P9gE
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] graph = new int[N+1][N+1];
        for(int i=0;i<N+1;i++) {
            Arrays.fill(graph[i], 100);
            graph[i][i]=0;
        }
        for(int i=0;i<N-1;i++)
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v]=1;
            graph[v][u]=1;
        }
        /*for(int i=0;i<N+1;i++)
        {
            System.out.println(Arrays.toString(graph[i]));
        }*/
        all_pair_shortest_path(graph,N+1);

    }
    static void all_pair_shortest_path(int[][] graph,int N)
    {
        int[][] cost = new int[graph.length][];
        for(int i=0;i<N;i++)
            cost[i]= Arrays.copyOf(graph[i],graph.length);
        for(int k=1;k<=N;k++)
        {
            for(int i=1;i<=N;i++)
            {
                for (int j=1;j<=N;j++)
                {
                    if(cost[i][k]+cost[k][j]<cost[i][j])
                    {
                        //System.out.printf("%d to %d (%d)is less when %d (%d)is between\n",i,j,k,cost[i][j],cost[i][k]+cost[k][j]);
                        cost[i][j]=cost[i][k]+cost[k][j];
                        //For path just add path(i,j)=k
                    }
                }
            }
        }
        for(int i=0;i<N;i++)
        {
            System.out.println(Arrays.toString(cost[i]));
        }
    }
}
