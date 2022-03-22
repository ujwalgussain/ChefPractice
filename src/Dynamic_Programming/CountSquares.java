package Dynamic_Programming;

public class CountSquares {
    /*
    matrix =
           [
             [0,1,1,1],
             [1,1,1,1],
             [0,1,1,1]
           ]
   dp =  [
             [0,1,1,1],
             [1,1,2,2],
             [0,1,2,3]
           ]
   Everytime matrix[i][j] increments by 1, there is smaller subsquare of size matrix[i][j], Line no 25

   */
    public int countSquares(int[][] matrix) {
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0)
                    continue;
                else if(i!=0 && j!=0)
                    matrix[i][j] = 1 + Math.min(matrix[i - 1][j], Math.min(matrix[i][j - 1], matrix[i - 1][j - 1]));
                ans+=matrix[i][j]; ///Line 16
            }
        }
        return ans;
    }
}
