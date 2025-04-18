package Dynamic_Programming.KnapSackProblem;



public class KnapsackDPImpl {
    //GFG: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
    static int knapSack(int W, int wt[], int cost[], int n) {
        //found ans
        if (n == 0 || W == 0)
            return 0;
        int profitWithCurr = 0, profitWithoutCurr=0;
        if (wt[n - 1] > W) {
            profitWithoutCurr = knapSack(W, wt, cost, n - 1);
            return profitWithoutCurr;
        }
        else
        {
            profitWithoutCurr = knapSack(W, wt, cost, n - 1);
            profitWithCurr = cost[n - 1] + knapSack(W - wt[n - 1], wt, cost, n - 1);
            return Math.max(profitWithCurr,profitWithoutCurr);
        }
    }

    // Returns the maximum value that
    // can be put in a knapsack of capacity W
    static int knapsack(int W, int[] val, int[] wt) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {

                // If there is no item or the knapsack's capacity is 0
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    int pick = 0;

                    // Pick ith item if it does not exceed the capacity of knapsack
                    if (wt[i - 1] <= j)
                        pick = val[i - 1] + dp[i - 1][j - wt[i - 1]];

                    // Don't pick the ith item
                    int notPick = dp[i - 1][j];

                    dp[i][j] = Math.max(pick, notPick);
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String args[]) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}
