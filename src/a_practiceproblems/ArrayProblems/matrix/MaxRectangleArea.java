package a_practiceproblems.ArrayProblems.matrix;

import a_practiceproblems.ArrayProblems.histogram.LargestRectangeInHistogram;

public class MaxRectangleArea {
    public int maximalRectangle(char[][] matrix) {
        //Question: https://leetcode.com/problems/maximal-rectangle/
        //https://www.youtube.com/watch?v=g8bSdXCG-lA -Tushar Roy
        //Also see largest Rectangular Area ib Histogram

        /*
        For Each row
            If curr==1 then dp[col]+=1
            Else dp[col]+=0
            After all cols are scanned find largest rectangle in histogram
         */
        int m  = matrix.length, n = matrix[0].length;
        int dp[] = new int[n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]=='1')
                    dp[j] = dp[j]+1;
                else
                    dp[j] = 0;
            }
            maxArea = Math.max(maxArea, LargestRectangeInHistogram.largestRectangleArea(dp));
        }
        return maxArea;
    }
}
