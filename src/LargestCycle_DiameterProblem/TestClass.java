package LargestCycle_DiameterProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;


/*The Logic is to first find the deepest node in the graph.
* Then from the DeepestNode find the other deepest node*/

public class TestClass {
    static TreeMap<Integer, List<Integer>> graph = new TreeMap();
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=0;i<N-1;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            addEdge(u,v);
            addEdge(v,u);
        }

        DFS(1,0,new boolean[N+1]);//Find 1st deepest node
        System.out.print(start+" ");
        total=0;
        DFS(start,0, new boolean[N+1]);//From the 1st deepest node find other deepest node
        System.out.print(start+" ");
    }
    static void addEdge(int u, int v)
    {
        if(graph.containsKey(u))
        {
            graph.get(u).add(v);
        }
        else
        {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(v);
            graph.put(u,al);
        }
    }
    static int total=0, start=-1;

    static void DFS(int root,int dis,boolean visited[])
    {
        System.out.println(root);
        visited[root]=true;
        if(dis>total)
        {
            total=dis;
            start=root;//Denotes the deepest Node
        }
        for(int i:graph.get(root))
        {
            if(!visited[i])
            {
                DFS(i,dis+1,visited);
            }
        }
    }
}
