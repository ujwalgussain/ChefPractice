package Dynamic_Programming;

import ChefProblems.src.Test;
import a_practiceproblems.TestClass3;

public class InterleavesStringsImpl {
    //https://leetcode.com/problems/interleaving-string
    //Recursive DP
    public boolean isInterleaveRec(String s1, String s2, String s3) {
        return check(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0,0,0);
    }
    public boolean check(char s1[], char s2[], char s3[], int a, int b, int c){
        if(a==s1.length && b ==s2.length && c==s3.length)
            return true;
        if(c==s3.length)
            return false;
        if(a!=s1.length &&  b!=s2.length && s1[a]!=s3[c] && s2[b]!=s3[c])
            return false;
        boolean res = false;
        if(a!=s1.length)
            res = (s1[a]==s3[c] && check(s1,s2,s3,a+1,b,c+1));
        if(!res && b!=s2.length)
            res = (s2[b]==s3[c] && check(s1,s2,s3,a,b+1,c+1));
        return res;
    }


    //Iterative DP
    //https://www.youtube.com/watch?v=ih2OZ9-M3OM
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] A = s1.toCharArray();
        char[] B = s2.toCharArray();
        char[] C = s3.toCharArray();
        int rows = A.length;
        int cols = B.length;
        boolean dp[][] = new boolean[rows+1][cols+1];
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                //First Cell
                if (i == 0 && j == 0) {
                    dp[0][0] = true;
                    continue;
                }
                //First Row
                if (i == 0) {
                    //compare s1
                    if (B[j - 1] == C[j - 1])
                        dp[i][j] = dp[i][j - 1];
                    continue;
                }
                //First Column
                if (j == 0) {
                    //compare s2
                    if (A[i - 1] == C[i - 1])
                        dp[i][j] = dp[i - 1][j];
                    continue;
                }
                if (A[i - 1] == C[i + j - 1] && B[j - 1] != C[i + j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                if (A[i - 1] != C[i + j - 1] && B[j - 1] == C[i + j - 1]) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                if (A[i - 1] == C[i + j - 1] && B[j - 1] == C[i + j - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    continue;
                }
            }
        }
        return dp[rows][cols];
    }

    public static void main(String[] args) {
        System.out.println(new InterleavesStringsImpl().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
