package a_practiceproblems.ArrayProblems.matrix;

public class SetMatrixZeroes {
    //https://leetcode.com/problems/set-matrix-zeroes/
    public void setZeroes(int[][] matrix) {
        int column0 =1;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            if(matrix[i][0]==0)
                column0 = 0;
            for (int j = 1; j < cols; j++) {
                if(matrix[i][j]==0)
                    matrix[i][0] = matrix[0][j] = 0; //mark the row and column
            }
        }
        for (int i = rows-1; i >=0 ; i--) {
            for (int j = cols-1; j>=1 ; j--) { //Check 1
                if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j]=0;
            }
            if(column0==0)
                matrix[i][0]=0;
        }
    }
    /*
    1. If we put j>=0 in second nested loop then the following test case will fail:
        Input       [[-4,-2147483648,6,-7,0],[-8,6,-8,-6,0],[2147483647,2,-9,-6,-10]]
        Output      [[0,0,0,0,0],[0,0,0,0,0],[0,2,-9,-6,0]]
        Expected    [[0,0,0,0,0],[0,0,0,0,0],[2147483647,2,-9,-6,0]]


    */
}
