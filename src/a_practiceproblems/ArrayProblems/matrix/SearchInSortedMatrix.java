package a_practiceproblems.ArrayProblems.matrix;

public class SearchInSortedMatrix {
    //https://leetcode.com/problems/search-a-2d-matrix/submissions/
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int i = 0, j = cols-1;
        while(i<rows && j>=0){
            if(matrix[i][j]==target)
                return true;
            else
            if(matrix[i][j]>target)
                j--;
            else
                i++;
        }
        return false;
    }
}
