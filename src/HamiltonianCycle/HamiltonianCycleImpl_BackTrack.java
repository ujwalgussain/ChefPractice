package HamiltonianCycle;

import java.util.Arrays;

public class HamiltonianCycleImpl_BackTrack {
    public static boolean isSafe(int G[][], int P[], int pos, int v2)
    {
        //If Path edge exists between previously added node in path mtx and new node v2.
        if(G[P[pos-1]][v2]==0)
            return false;
        //check if v2 is already present in the path mtx
        for(int i=0;i<pos;i++)
        {
            if(P[i]==v2)
                return false;
        }
        return true;
    }
    public static boolean hamCycleUtil(int[][] G, int[] P, int pos)
    {
        //this method will return true if path exists
        if(pos==G.length)
        {
            //If last node in path matrix has an edge to first Node ie.,0 return true
            if(G[P[pos-1]][P[0]]==1)
            {
                return true;
            }
            return false;
        }
        //try all vertices as candidates for the path
        for(int i=1;i<G.length;i++)
        {
            //If vertex is connected to prev vertex in path Matrix && not already present in path Matrix,
            //then it is safe.
            if(isSafe(G,P,pos,i))
            {
                P[pos]=i; // add the vertex to path mtx
                if(hamCycleUtil(G,P,pos+1)) //recursively Check for all paths
                {
                    return true;
                }
                //if current vertex fails to create a Hamiltonian Path.
                P[pos]=-1;
            }
        }
        return false;
    }
    public static boolean hamCycle(int G[][])
    {
        int path[] = new int[G.length];
        Arrays.fill(path,-1);
        path[0]=0;
        if(hamCycleUtil(G,path,1))
        {
            System.out.println("Path Exists: ");
            //print path;
            printPath(path);
            return true;
        }
        else
        {
            System.out.println("Path doesnt exists");
            return false;
        }
    }
    static void printPath(int P[])
    {
        System.out.println(Arrays.toString(P));
    }

    public static void main(String args[])
    {
        int[][] G =
                {{0,1,0,1,0},
                {1,0,1,1,1},
                {0,1,0,0,1},
                {1,1,0,0,1},
                {0,1,1,1,0}};
        hamCycle(G);

        G=new int[][]{{0,1,0,0,0,1},
                    {1,0,1,0,1,0},
                    {0,1,0,1,0,1},
                    {0,0,1,0,1,0},
                    {0,1,0,1,0,0},
                    {1,0,1,0,0,0}};
        hamCycle(G);
    }
}

