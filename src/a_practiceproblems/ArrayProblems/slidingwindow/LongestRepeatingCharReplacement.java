package a_practiceproblems.ArrayProblems.slidingwindow;

public class LongestRepeatingCharReplacement {
    //https://leetcode.com/problems/longest-repeating-character-replacement/
    //https://www.youtube.com/watch?v=5QpMpO2CAb0


    /* Problem
    You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
    Return the length of the longest substring containing the same letter you can get after performing the above operations.

        Example 1:

        Input: s = "ABAB", k = 2
        Output: 4
        Explanation: Replace the two 'A's with two 'B's or vice versa.
        Example 2:

        Input: s = "AABABBA", k = 1
        Output: 4
        Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
        The substring "BBBB" has the longest repeating letters, which is 4.
     */
    public int characterReplacement(String s, int k) {
        /*
        for any substring, replacements will be substr len - count of maxOccuring Char.
        Hence window will become invalid if replacements exceed k..so we need to move start forward
         */
        int maxLength = 0;
        int maxCount = 0;
        int freq[] = new int[26];
        for (int end = 0,start=0; end < s.length(); end++) {
            int count = ++freq[s.charAt(end)-'A'];
            maxCount = Math.max(maxCount,count);
            while(end-start+1-maxCount>k){
                //more than k replacements
                --freq[s.charAt(start++)-'A'];
            }
            //Valid substring found - start will be at position from where we will require <= k replacements
            maxLength = Math.max(maxLength,end-start+1);
        }
        return maxLength;
    }
}
