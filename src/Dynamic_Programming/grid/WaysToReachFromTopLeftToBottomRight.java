package Dynamic_Programming.grid;

public class WaysToReachFromTopLeftToBottomRight {
    /*
    Reference : Udemy Course Dynamic Programming 1
    We are allowed to move either right or down
    So we can say that for any cell[i,j] we can reach there from either left[i,j-1] or top[i,j-1]
    so to reach [i,j] = ways to reach [i,j-1] + ways to reach [i,j-1]

    Initially m=3 n=3
        0	1	2
    0	1	1	1  <- will come here from in one path only
    1	1	0	0
    2	1	0	0
        ^
    will come here from in one path only

     Finally m=3 n=3
        0	1	2
    0	1	1	1
    1	1	2	3
    2	1	3	6 <- answer

     */
    public int uniquePaths(int m, int n) {
        //Only 2 moves are allowed right or bottom
        int[][] dp = new int[m][n];
        //only one way to reach any cell in 1st row ie., from left
        for(int i=0;i<m;i++)
            dp[i][0] = 1;
        //only one way to reach any cell in 1st column ie., from right
        for(int i=0;i<n;i++)
            dp[0][i] = 1;
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                //we can reach i j fro, left or top
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //1 represents obstacle
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int dp[][] = new int[m][n];

        //base case
        if(obstacleGrid[0][0]==1)
            return 0;

        for(int i=0;i<m;i++)
        {
            //if current cell is obstacle then there is no way to reach the subsequent cells in the row
            if(obstacleGrid[i][0] == 1)
                break;
            dp[i][0]=1;
        }

        for(int i=0;i<n;i++)
        {
            //if current cell is obstacle then there is no way to reach the subsequent cells in the column
            if(obstacleGrid[0][i] == 1)
                break;
            dp[0][i]=1;
        }

        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(obstacleGrid[i][j]!=1)
                {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
                else
                {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m-1][n-1];

    }
}
