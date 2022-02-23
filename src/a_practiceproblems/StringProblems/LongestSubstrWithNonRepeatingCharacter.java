package a_practiceproblems.StringProblems;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstrWithNonRepeatingCharacter {
    //https://practice.geeksforgeeks.org/problems/longest-distinct-characters-in-string5848/1/#
    //src/test/a_practiceproblems/StringProblems/LongestSubstrWithNonRepeatingCharacterTest.java
    //Test Cases:
    //Case 1: "abcabcbb" - 3
    //Case 2: "abba" - 2
    //Case 3: "tmmuzxt" - 5
    //Case 4: "bbbbbb" - 1
    public int lengthOfLongestSubstring(String text) {
        int max = 1, start=0;
        HashSet<Character> set = new HashSet<>();
        char arr[] = text.toCharArray();
        for(int i=0;i<text.length();i++){
            while(set.contains(arr[i])){
                set.remove(arr[start++]);
            }
            int len = i-start+1;
            max = Math.max(max,len);
            set.add(arr[i]);
        }
        return max;
    }
}
