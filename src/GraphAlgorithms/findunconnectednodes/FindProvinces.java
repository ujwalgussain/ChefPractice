package GraphAlgorithms.findunconnectednodes;

public class FindProvinces {
    //https://leetcode.com/problems/number-of-provinces/submissions/
    public int findCircleNum(int[][] isConnected) {
        boolean visited[] = new boolean[isConnected.length];
        int c = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if(!visited[i]){
                c++;
                dfs(isConnected, visited,i);
            }
        }
        return c;
    }
    void dfs(int[][] isConnected, boolean[] visited, int u){
        visited[u] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if(!visited[i] && isConnected[u][i]==1)
                dfs(isConnected, visited, i);
        }
    }
}
