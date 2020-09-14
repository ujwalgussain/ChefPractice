package GraphAlgorithms;

import java.util.Arrays;

public class AdjacencyMatrix implements Graph{

    int[][] G;
    int V;
    int E;
    boolean isDirected;
    AdjacencyMatrix()
    {

    }
    AdjacencyMatrix(int x)
    {
        V=x;
        G=new int[x][x];
        isDirected=false;
    }
    AdjacencyMatrix(int x, boolean isDirected)
    {
        V=x;
        G=new int[x][x];
        this.isDirected=isDirected;
    }

    @Override
    public void addEdge(int u, int v) {
        E++;
        G[u][v]=1;
        if(!isDirected)
        {
            G[v][u]=1;
        }
    }

    @Override
    public String toString() {
        StringBuilder adjMtx=new StringBuilder();
        adjMtx.append("{\n");
        for(int[] i:G)
            adjMtx.append(Arrays.toString(i));
        adjMtx.append("\n}\n");
        return String.format("Adjacency Matrix->%s, Edges-%d, Vertices-%d",adjMtx.toString(),E,V);
    }
}
