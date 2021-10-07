package Dynamic_Programming;

import java.util.Arrays;

public class WaysToDecodeAString {
    /*public int numDecodings(String A) {
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
    }*/

    // My Approach:
    public int numDecodings(String A) {
        int N = A.length();
        if (N > 0 && A.charAt(0) == '0')
            return 0;
        int dp[] = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        int mod = 1000000007;
        char str[] = A.toCharArray();
        for (int i = 2; i < dp.length; i++) {
            if (str[i - 1] != '0')
                dp[i] = dp[i - 1]%mod;
            if (isValid(str, i))
                dp[i] += dp[i - 2]%mod;
            // System.out.printf("i=%s, dp=%s\n",i,Arrays.toString(dp));
        }
        return dp[dp.length - 1];
    }

    public boolean isValid(char str[], int i) {
        return str[i - 2] == '1' ||
                (str[i - 2] == '2' &&
                        str[i - 1] < '7');
    }

    //GFG Approach:
    int countDecodingDP(char digits[],
                        int n)
    {
        // A table to store results of subproblems
        int count[] = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        if(digits[0]=='0')   //for base condition "01123" should return 0
            return 0;
        for (int i = 2; i <= n; i++)
        {
            count[i] = 0;

            // If the last digit is not 0,
            // then last digit must add to
            // the number of words
            if (digits[i - 1] > '0')
                count[i] = count[i - 1];

            // If second last digit is smaller
            // than 2 and last digit is smaller
            // than 7, then last two digits
            // form a valid character
            if (digits[i - 2] == '1' ||
                    (digits[i - 2] == '2' &&
                            digits[i - 1] < '7'))
                count[i] += count[i - 2];
            System.out.printf("i=%s, dp=%s\n",i,Arrays.toString(count));
        }
        return count[n];
    }
}
