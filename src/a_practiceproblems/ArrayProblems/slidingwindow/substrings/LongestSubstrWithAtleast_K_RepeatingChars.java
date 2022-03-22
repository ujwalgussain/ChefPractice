package a_practiceproblems.ArrayProblems.slidingwindow.substrings;

public class LongestSubstrWithAtleast_K_RepeatingChars {
    /*
    https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-c haracters/
    Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.

        Example 1:

        Input: s = "aaabb", k = 3
        Output: 3
        Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
        Example 2:

        Input: s = "ababbc", k = 2
        Output: 5
        Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
     */

    /*
       Count occurence of each char in str
       Scan each char
           if occurence of char is less than k
           we have 2 places where we can find the answer ie., answer can be before char or after char
           repeat the same process
        Ex : aaabccc
             after b answer can be in aaa or ccc
        Ex : aabccca
             after b answer can be in aaa or ccca...
        */
    public int longestSubstring(String s, int k) {
        return helper(s, 0, s.length() - 1, k);
    }

    public int helper(String s, int start, int end, int k) {
        if (end-start+1<k)
            return 0;
        int freq[] = new int[26];
        for (int i = start; i <= end; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = start; i <= end; i++) {
            if (freq[s.charAt(i) - 'a'] < k) {
                //invalid character
                int j = i;
                while (j <= end && freq[s.charAt(j) - 'a'] < k) {
                    j++;
                }
                return Math.max(
                        helper(s, start, i - 1, k),
                        helper(s, j, end, k)
                );
            }

        }
        return end - start + 1;
    }
}
