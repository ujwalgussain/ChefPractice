package Amazon_Interview_Questions.SubSetSumProblem;

import java.util.Arrays;

public class KnapSack01DPImpl {
    static void solve(int wt[], int cost[], int w)
    {
        //rows represent Sum cols represent weights
        //Each cell data represents the max profit that can be achieved with sum as i and set of weights till j
        int rows = w+1;
        int cols = wt.length+1;
        int dp[][] = new int[rows][cols];
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j]=dp[i][j-1];
                if(i>=wt[j-1])
                {
                        dp[i][j] = Math.max(cost[j-1]+dp[i-wt[j-1]][j-1],dp[i][j]);
                }
            }
        }
        for(int i[] : dp)
        {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("Max Profit -> "+dp[rows-1][cols-1]);
    }

    public static void main(String[] args) {
        int wt[] = {1,2,3};
        int cost[] = {10,15,40};
        solve(wt,cost,6);
    }
}
