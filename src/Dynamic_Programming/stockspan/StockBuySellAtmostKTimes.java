package Dynamic_Programming.stockspan;

import java.util.HashMap;

public class StockBuySellAtmostKTimes {
    //https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
    public int maxProfitIterativeDP(int[] prices, int K) {
        int n = prices.length;
        int profit[][] = new int[K+1][n];
        for  (int i = 0; i <= K; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    continue;
                int max = Integer.MIN_VALUE;
                for (int k = 0; k < j; k++) {
                    max = Math.max(
                            max,
                            prices[j] - prices[k] + profit[i - 1][k]
                    );
                }
                profit[i][j] = Math.max(profit[i][j - 1], max);
            }
        }
        return profit[K][n - 1];
    }

    //Optimized



    static int maxProfit(int prices[], int k) {
        // code here
        int n = prices.length;
        int profit[][] = new int[k+1][n];

        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = 0; j < prices.length; j++) {
                /**
                 *  prices[j] - prices[k] + profit[i - 1][k] .... for k=0 to j
                 *  this can be rearranged and written as prices[j] + profit[i - 1][k] - prices[k]
                 *  With each iteration we can now maintain the maxValue of profit[i - 1][k] - prices[k]
                 */
                profit[i][j] = Math.max(profit[i][j-1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, profit[i-1][j] - prices[j]);
            }
        }
        return  profit[k][n - 1];
    }


}
