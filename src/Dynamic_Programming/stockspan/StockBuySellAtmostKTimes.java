package Dynamic_Programming.stockspan;

import java.util.HashMap;

public class StockBuySellAtmostKTimes {
    //https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
    public int maxProfitIterativeDP(int[] prices, int K) {
        int n = prices.length;
        int profit[][] = new int[3][n];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    continue;
                int max = Integer.MIN_VALUE;
                for (int m = 0; m < j; m++) {
                    max = Math.max(
                            max,
                            prices[j] - prices[m] + profit[i - 1][m]
                    );
                }
                profit[i][j] = Math.max(profit[i][j - 1], max);
            }
        }
        return profit[K][n - 1];
    }
}
