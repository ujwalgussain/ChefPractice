package Dynamic_Programming.lis;

import LargestCycle_DiameterProblem.TestClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingThenDecreasingSubsequence {

    public int longestSubsequenceLength(final List<Integer> A) {
        int lis1[] = lis(A);
        //System.out.println(Arrays.toString(lis1));
        int[] lis2 = lisReverse(A);
        ///System.out.println(Arrays.toString(lis2));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            max = Math.max(max, (lis1[i] + lis2[i]) - 1);
        }
        return max;
    }

    public int[] lis(final List<Integer> A) {
        int len = A.size();
        int dp[] = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(j) < A.get(i))
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }
        return dp;
    }

    public int[] lisReverse(final List<Integer> A) {
        int len = A.size();
        int dp[] = new int[len];
        Arrays.fill(dp, 1);
        for (int i = len - 2; i >= 0; i--) {
            for (int j = len - 1; j > i; j--) {
                if (A.get(j) < A.get(i))
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }
        return dp;
    }
}
