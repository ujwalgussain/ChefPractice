package Dynamic_Programming;

import java.util.HashMap;

public class WildcardMatching {
    /*
    if pattern is fully processed
        if string is full processed then return true else false;
    if str is fully processed then
        check if remaining chars in pattern are '*' else return false;
    if pattern[j] is char
        return str[i] = pattern[j] AND repeat the steps for i+1, j+1
    if pattern[j] is '?'
        match single character ie., repeat the steps for i+1, j+1
    if pattern[j] is '*'
        either 0 occurence or 1 occurence
        ie.,  repeat the steps for i+1, j AND i, j+1
     */

    public int isMatch(final String A, final String B) {
        return isMatch(A, B, 0, 0) ? 1 : 0;
    }

    HashMap<String, Boolean> map = new HashMap<>();
/*

    public boolean isMatch(String A, String B, int i, int j) {
        boolean result;
        String key = i + "-" + j;
        if (map.containsKey(key))
            return map.get(key);
        //Pattern is Processed
        if (j == B.length()) {
            result = i == A.length();
        } else if (i == A.length()) { //String is Processed
            while (j < B.length() && B.charAt(j) == '*') {
                j++;
            }
            result = j == B.length(); //Continue any char other than * is found or pattern ends
        } else if (Character.isLetter(B.charAt(j))) {

            result = (A.charAt(i) == B.charAt(j)) && isMatch(A, B, i + 1, j + 1);
        } else if (B.charAt(j) == '?') {

            result = isMatch(A, B, i + 1, j + 1);
        } else {
            result = isMatch(A, B, i + 1, j) || isMatch(A, B, i, j + 1);
        }
        map.put(key, result);
        return result;
    }*/

    //Added While loops to decrease recursion.
    public boolean isMatch(String A, String B, int i, int j) {
        boolean result;
        String key = i + "-" + j;
        if (map.containsKey(key))
            return map.get(key);
        //Pattern is Processed
        if (j == B.length()) {
            result = i == A.length();
        } else if (i == A.length()) { //String is Processed
            while (j < B.length() && B.charAt(j) == '*') {
                j++;
            }
            result = j == B.length(); //Continue any char other than * is found or pattern ends
        } else if (Character.isLetter(B.charAt(j))) {
            while (i < A.length() && j < B.length() && Character.isLetter(B.charAt(j))) {
                if (A.charAt(i) != B.charAt(j))
                    return false;
                i++;
                j++;
            }
            result = isMatch(A, B, i, j);
        } else if (B.charAt(j) == '?') {
            /*while (B.charAt(j) == '?') {
                i++;
                j++;
            }*/
            result = isMatch(A, B, i + 1, j + 1);
        } else {
            result = isMatch(A, B, i + 1, j) || isMatch(A, B, i, j + 1);
        }
        map.put(key, result);
        return result;
    }


    /*Dynamic Programming*/

    public int isMatchDP(final String text, final String pattern) {
        int rows = pattern.length(), cols = text.length();
        boolean[][] dp = new boolean[rows + 1][cols + 1];
        dp[0][0] = true;
        // If pattern starts with * it will match with empty string
        // Ex: text = aaaa and pattern = *a OR **a OR ****b
        for (int i = 1; i <= rows; i++) {
            if (pattern.charAt(i - 1) != '*') //first * in the pattern
                break;
            dp[i][0] = true; //col = 0 means empty string
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                //dp[i][j] is already false;
                if (Character.isLetter(pattern.charAt(i - 1))) {
                    dp[i][j] = pattern.charAt(i - 1) == text.charAt(j - 1) && dp[i - 1][j - 1];
                } else if (pattern.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[rows][cols] ? 1 : 0;
    }

}
