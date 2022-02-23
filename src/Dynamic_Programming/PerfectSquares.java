package Dynamic_Programming;

import java.util.HashMap;

public class PerfectSquares {
    /*
    https://leetcode.com/problems/perfect-squares/
    Given an integer n, return the least number of perfect square numbers that sum to n.
    A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

    Example 1:

    Input: n = 12
    Output: 3
    Explanation: 12 = 4 + 4 + 4.
    Example 2:

    Input: n = 13
    Output: 2
    Explanation: 13 = 4 + 9.
     */
     /*
        n = 6 -> possible solutions are
        1 + 1 + 1 + 1 + 1 + 1
        1 + 1 + 4
        1 + 4 + 1
        4 + 1 + 1

         */
    public int numSquares(int n) {
        return recursive(n);
    }
    //Recursive Approach
    HashMap<Integer, Integer> map = new HashMap<>();
    public int recursive(int n) {
        int result;
        if(map.containsKey(n))
            return map.get(n);
        if (n == 0) {
            result = 0;
        } else if (n == 1) {
            result = 1;
        } else {
            int minValue = Integer.MAX_VALUE;
            for (int i = 1; i * i <= n; i++) {
                minValue = Math.min(minValue, 1 + recursive(n - i * i));
            }
            result = minValue;
        }
        map.put(n,result);
        return result;
    }
    //
    public int dpApproach(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int minValue = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                //we Will always enter the loop for j=1
                //if n=10, j*j means find min of dp[10-1], dp[10-4], dp[10-9]
                //Hence at each position we are cons
                minValue = Math.min(minValue,dp[i-(j*j)]);
            }
            dp[i] = minValue+1;
        }
        return dp[n];
    }
}
