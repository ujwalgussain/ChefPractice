package a_practiceproblems.StringProblems.palindrome.mininsertions;

public class MinInsertionsInEndToMakePalindrome {
    //Similar to MinInsertionsInFrontToMakePalindrome.java
    //Logic  = length - length of longest Palindromic suffix....reverse the string
    public int solve(String A) {
        int len = A.length();
        A = new StringBuilder(A).reverse().toString().concat("$").concat(A);
        int n = A.length();
        int lps[] = new int[n];
        int i = 1;
        int j = 0;
        while (i >= 0) {
            if (A.charAt(i) == A.charAt(j)) {
                lps[i++] = ++j;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return len - lps[n - 1];
    }
}
