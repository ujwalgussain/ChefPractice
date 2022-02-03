package Dynamic_Programming;

public class FindMaxSquareSubMatrix {
    public static int solution(int[][] input) {
        //write your code here
        int m = input.length, n = input[0].length;
        int dp[][] = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0 || j==0)
                    dp[i][j] = input[i][j];
                else{
                    if(input[i][j]==1){
                        dp[i][j] = 1 + Math.min(
                                dp[i-1][j],  //top
                                Math.min(
                                        dp[i-1][j-1], // diag
                                        dp[i][j-1] // left
                                )
                        );
                    }
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
    
}
