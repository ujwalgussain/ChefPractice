package Dynamic_Programming.stockspan;

public class StockBuySellAtmost2Times {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int t[] = new int[n];
        t[0] = 0;
        t[n-1] = prices[n-1];
        int minFront = prices[0];
        int maxProfitFront = 0;
        for (int i = 1; i < n; i++) {
            maxProfitFront  = Math.max(t[i-1], prices[i] - minFront);
            minFront = Math.min(minFront, prices[i]);
            t[i] = maxProfitFront;
        }
        int maxBack = prices[n-1];
        int ans = 0;
        int maxProfitBack = 0;
        for (int i = n-2; i >= 0; i--) {
            maxProfitBack =  Math.max(maxProfitBack,maxBack-prices[i]);
            maxBack = Math.max(maxBack,prices[i]);
            t[i] += maxProfitBack;
            ans = Math.max(ans,t[i]);
        }
        return ans;
    }
}
