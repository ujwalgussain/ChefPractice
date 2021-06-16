package Dynamic_Programming;

import ChefProblems.src.Test;

public class InterleavesStringsImpl {
    //we should use Iterative DP
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length())
            return false;
        return helper(
                s1.toCharArray(),
                s2.toCharArray(),
                s3.toCharArray(),
                s1.length() - 1,
                s2.length() - 1,
                s3.length() - 1);
    }

    public boolean helper(char[] s1, char s2[], char s3[], int i, int j, int k) {
        // k==-1 and i & j == -1 -> all chars are found return true
        // if s3[k] != s1[i] & s2[j] return false
        //
//        System.out.printf("s1[%d]=%s s2[%d]=%s s3[%d]=%s\n", i, s1[i], j, s2[j], k, s3[k]);
        if (k < 0) {
            if (i < 0 && j < 0)
                return true;
            return false;
        }
        if (i >= 0 && j >= 0 && k >= 0) {
            if (s3[k] != s1[i] && s3[k] != s2[j])
                return false;
            if (s3[k] == s1[i] && s3[k] == s2[j]) {
                //try either of one
                return helper(s1, s2, s3, i - 1, j, k - 1) || helper(s1, s2, s3, i, j - 1, k - 1);
            }
        }
        if (i >= 0 && s3[k] == s1[i]) {
            return helper(s1, s2, s3, i - 1, j, k - 1);
        }
        if (j >= 0 && s3[k] == s2[j]) {
            return helper(s1, s2, s3, i, j - 1, k - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new InterleavesStringsImpl().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
