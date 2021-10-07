package Dynamic_Programming.KnapSackProblem;


import java.util.Set;

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

    public static void main(String args[]) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}
