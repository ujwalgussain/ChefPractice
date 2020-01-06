import java.util.*;

public class EvenEdgesImpl {
    class Graph{
        TreeMap<Integer, Integer> adjnodeCountMap = new TreeMap<>();
        HashMap<Integer,ArrayList<String>> adjList = new HashMap<>();
        Graph(int N)
        {
            int i=0;
            while(++i<=N)
            {
                adjnodeCountMap.put(i,0);
            }
        }
        void addEdge(Integer u, Integer v)
        {
            adjnodeCountMap.put(u,(adjnodeCountMap.get(u))+1);
            adjnodeCountMap.put(v,(adjnodeCountMap.get(v))+1);
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
            if((M&2)!=0)
            {

                Iterator<Map.Entry<Integer, Integer>> itr = g.adjnodeCountMap.entrySet().iterator();
                while(itr.hasNext())
                {
                    Map.Entry<Integer, Integer> entry =itr.next();
                    System.out.println(entry);
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
    static void verify(int arr[], Graph g)
    {

    }
    public static void main(String... args)
    {
//        minK();

    }
    void settersSoln()
    {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = (sc.hasNext())?sc.nextInt():0;
        int testCaseCounter = -1;
        while(++testCaseCounter<testCaseCount)
        {
            int N  = sc.hasNext()?sc.nextInt():0;
            int degree[]=new int[N];
            int M = sc.hasNext()?sc.nextInt():0;
            int u=-1,v=-1;
            for(int i=0;i<M;i++)
            {
                u =sc.nextInt();
                v = sc.nextInt();
                degree[u]^=1;
                degree[v]^=1;
            }
            if((M&1)==0)
            {
                System.out.println("1");
                for(int i=0;i<N;i++)
                {
                    System.out.printf("%d ",1);
                }
                System.out.println();
            }
            else
            {
                for(int i=0; i<N;i++)
                {
                    if(degree[i]==1)
                    {
                        for(int j=0;j<N;j++)
                        {
                            if(j==i)
                                System.out.printf("%d ",2);
                            System.out.printf("%d ",1);
                        }
                        System.out.println();
                        return;
                    }
                }
                for(int i=0;i<N;i++)
                {
                    if(i==u)
                        System.out.printf("%d ",2);
                    if(i==v)
                        System.out.printf("%d ",3);
                    System.out.printf("%d ",1);
                }
                System.out.println();
            }
        }
    }
}
