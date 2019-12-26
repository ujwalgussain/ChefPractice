import java.util.*;

public class EvenEdgesImpl {
    class Graph{
        TreeMap<Integer, Integer> adjList = new TreeMap<>();
        Graph(int N)
        {
            int i=0;
            while(++i<=N)
            {
                adjList.put(i,0);
            }
        }
        void addEdge(Integer u, Integer v)
        {
            adjList.put(u,(adjList.get(u))+1);
            adjList.put(v,(adjList.get(v))+1);
        }
    }
    static int[] getPartitionArr(int N){
        int[] arr = new int[N];
        for(int i=0;i<N;i++)
        {
            arr[i]=1;
        }
        return arr;
    }
    static void  printAns(int K, int[] arr)
    {
        System.out.println(K);
        for(int ele:arr)
            System.out.printf("%d ",ele);
        System.out.println();
    }
    static void minK()
    {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = (sc.hasNext())?sc.nextInt():0;
        int testCaseCounter = -1;
        while(++testCaseCounter<testCaseCount)
        {
            int N = (sc.hasNext())?sc.nextInt():0;
            int M = (sc.hasNext())?sc.nextInt():0;
            int[] vertex_arr = getPartitionArr(N);
            Graph g = new EvenEdgesImpl().new Graph(N);
            int i =-1;
            int u=-1 , v=-1;
            while(++i<M)
            {
                 u =sc.nextInt();
                 v =sc.nextInt();
                g.addEdge(u,v);
            }
            if(M%2!=0)
            {
                Iterator<Map.Entry<Integer, Integer>> itr = g.adjList.entrySet().iterator();
                while(itr.hasNext())
                {
                    Map.Entry<Integer, Integer> entry =itr.next();
                    int size=entry.getValue();
                    if(!((size&1)==0))
                    {
                        vertex_arr[entry.getKey()-1] =2;
                        printAns(2,vertex_arr);
                        return;
                    }
                }
                vertex_arr[u-1] = 2;
                vertex_arr[v-1] = 3;
                printAns(3,vertex_arr);
            }
            else
            {
                printAns(1,vertex_arr);
            }
        }
    }
    public static void main(String... args)
    {
        minK();
    }
}
