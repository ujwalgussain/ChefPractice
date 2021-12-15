package Dynamic_Programming.udemy;

public class StockBuySell {
    /*
        Logic
        Maximum Profit will be the maximum difference between buy and sell
        buy should be minimum and sell should be maximum

                7	1	5	3	6	4
        min		    1	1	1	1	1
        Profit	    0	4	2	5	3

     */
    //find max difference
    public int maxProfit(int[] prices) {
        int min_upto = prices[0];
        int max_profit = 0;
        for(int i=1; i<prices.length;i++) {
            min_upto = Math.min(min_upto, prices[i]);
            if(min_upto<prices[i])
            {
                int profit = prices[i]-min_upto;
                max_profit = Math.max(max_profit,profit);
            }
        }
        return max_profit;
    }

    public static void main(String[] args) {
        System.out.println(new StockBuySell().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
