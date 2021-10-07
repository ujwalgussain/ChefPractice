package Dynamic_Programming.grid;

import java.util.ArrayList;

public class MaxSquareSubMatrix {
    //https://www.interviewbit.com/problems/maximum-sum-square-submatrix/
    /*
    Problem Description
        Given a 2D integer matrix A of size N x N find a B x B submatrix where B<= N and B>= 1, such that sum of all the elements in submatrix is maximum.
     */
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int rows = A.size();
        int cols = A.get(0).size();
        int dp[][] = new int[rows+1][cols+1];//sum of mtx upto i j
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                dp[i][j] = get(A,i-1,j-1)
                        + dp[i-1][j] //prev row
                        + dp[i][j-1] //prev cols
                        - dp[i-1][j-1]; //since diag will be included in  prev row and prev col
            }
        }
        int maxsum = Integer.MIN_VALUE;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int sum = 0;
                if(i-B>=0 && j-B>=0){
                    sum = dp[i][j]
                            - dp[i-B][j]
                            -dp[i][j-B]
                            +dp[i-B][j-B];
                    maxsum = Math.max(sum,maxsum);
                }
            }
        }
        return maxsum;
    }
    static int get(ArrayList<ArrayList<Integer>> a, int i, int j) {
        return a.get(i).get(j);
    }

    /*
        Example Input
        Input 1:

         A = [
                [1, 1, 1, 1, 1]
                [2, 2, 2, 2, 2]
                [3, 8, 6, 7, 3]
                [4, 4, 4, 4, 4]
                [5, 5, 5, 5, 5]
             ]
         B = 3
        Input 2:

         A = [
                [2, 2]
                [2, 2]
            ]
         B = 2


        Example Output
        Output 1:

         48
        Output 2:

         8


        Example Explanation
        Explanation 1:

            Maximum sum 3 x 3 matrix is
            8 6 7
            4 4 4
            5 5 5
            Sum = 48
        Explanation 2:

         Maximum sum 2 x 2 matrix is
          2 2
          2 2
          Sum = 8
     */

}
