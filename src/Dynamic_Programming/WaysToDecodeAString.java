package Dynamic_Programming;

import java.util.Arrays;

public class WaysToDecodeAString {
    public int numDecodings(String A) {
        int N = A.length();
        int dp[] = new int[N+1];
        dp[N] =1;
        return dfs(0,N,A,dp);
    }
    public int dfs(int i, int N, String A, int dp[])
    {
        if(i>N)
            return 0;
        if(dp[i]!=0)
            return dp[i];
        char c = A.charAt(i);
        if(c=='0')
            return 0;
        int res = dfs(i+1,N,A,dp);
        if(i+1<N && (c == '1' ||
                (c=='2' && Arrays.asList('0', '1', '2', '3', '4', '5', '6').contains(A.charAt(i + 1)))))
            res += dfs(i+2,N,A,dp);
        dp[i] = res;
        return res;
    }
}
