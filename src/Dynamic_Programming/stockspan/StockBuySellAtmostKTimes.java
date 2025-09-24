package Dynamic_Programming.stockspan;

import java.util.HashMap;

public class StockBuySellAtmostKTimes {
    //https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
    static int maxProfit(int prices[], int K) {
        return maxProfitOptimized(prices, K);
    }

    static int maxProfitOptimized(int prices[], int K) {
        /**
         *  prices[j] - prices[l] + profit[i - 1][l] .... for l=0 to j
         *  this can be rearranged and written as prices[j] + profit[i - 1][l] - prices[l]
         *  With each iteration we can now maintain the maxValue of profit[i - 1][l] - prices[l]
         */
        int n = prices.length;
        int profit[][] = new int[K+1][n];
        for (int i = 1; i <= K ; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < n; j++) {
                profit[i][j] = Math.max(profit[i][j-1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, profit[i-1][j] - prices[j]);
            }
        }
        return profit[K][n-1];
    }

    //--------------------------Bottom up Approach--------------------------//
    static int maxProfitDP(int prices[], int K) {
        // code here

        int n = prices.length;
        int profit[][] = new int[K+1][n];
        for  (int i = 1; i <= K; i++) {
            for (int j = 1; j < n; j++) {
                int max = Integer.MIN_VALUE;
                for (int l = 0; l < j; l++) {
                    max = Math.max(
                            max,
                            prices[j] - prices[l] + profit[i - 1][l]
                    );
                }
                profit[i][j] = Math.max(profit[i][j - 1], max);
            }
        }
        return profit[K][n - 1];
    }


    //--------------------------Top Down Recursive Approach--------------------------//
    /* Solution s = new Solution();

        int memo[][] = new int[prices.length][k+1];
        for(int[] i : memo) {
            Arrays.fill(i, -1);
        }
        return s.maxProfitTopDown(0, prices, k, memo);*/

    int maxProfitTopDown(int start, int prices[], int k, int[][] memo) {
        if(start==prices.length || k==0) {
            return 0;
        }
        if(memo[start][k]!=-1) {
            return memo[start][k];
        }
        int maxProfit = 0;
        for (int i = start; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if(prices[j]>prices[i])
                    maxProfit = Math.max(maxProfit, (prices[j] - prices[i]) + maxProfitTopDown(j+1, prices, k-1,memo));
            }
        }
        memo[start][k] = maxProfit;
        return maxProfit;
    }

}
