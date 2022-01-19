package a_practiceproblems.ArrayProblems.matrix;

public class MaximalSquareMatrix {
    public int maximalSquare(char[][] matrix) {
        //https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
         /*
        Intialize 1st row and 1st col of dp[][]-> If m[i][j]==1 then 1 else 0;

        for i = 1 to rows
            for j=1 to cols
                m[i][j]==1 == 1 then dp[i][j]= 1 + min(top,diag-left, bottom)
        Note the maxValue in dp[][] is size of square
         */
        int m = matrix.length, n = matrix[0].length;
        int dp[][] = new int[m+1][n+1];
        int ans = 0;
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1], //diag left
                            Math.min(
                                    dp[i - 1][j], //top
                                    dp[i][j - 1] //left
                            )
                    );
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans*ans;
    }
}
