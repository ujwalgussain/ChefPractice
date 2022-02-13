package Dynamic_Programming.longestcommonsubsequence;

import java.util.HashMap;

public class LongestRepeatingSubsequence {
    /*
    https://www.interviewbit.com/problems/repeating-subsequence/

    Problem Description

    Given a string A, find length of the longest repeating sub-sequence such that the two subsequence don’t have same string character at same position,
    i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.

    NOTE: Sub-sequence length should be greater than or equal to 2.
        Input 1:  A = "abab" -> 1 [ "ab" is repeated.]
        Input 2:   A = "abba" -> 0 [There is no repeating subsequence.]
     */

    /*
    This problem is similar to LCS. Except if chars are same we need to check that idx is not same
     */
    public int anytwo(String A) {
        return longestCommonSubsequence(A, A, A.length() - 1, A.length() - 1) < 2 ? 0 : 1;
    }

    HashMap<String, Integer> map = new HashMap<>();

    public int longestCommonSubsequence(String A, String B, int i, int j) {
        int result;
        String key = i + "-" + j;
        if (map.containsKey(key))
            return map.get(key);
        if (i < 0 || j < 0) {
            result = 0;
        } else if (i != j && A.charAt(i) == B.charAt(j)) { //Different Indexes are compared
            result = 1 + longestCommonSubsequence(A, B, i - 1, j - 1);
        } else {
            result = Math.max(longestCommonSubsequence(A, B, i - 1, j), longestCommonSubsequence(A, B, i, j - 1));
        }
        map.put(key, result);
        return result;
    }
}
