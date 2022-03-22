package a_practiceproblems.ArrayProblems.slidingwindow.substrings;

import java.util.HashSet;

public class LongestSubstrWithUpperAndLowercaseChars {
    //https://leetcode.com/problems/longest-nice-substring/submissions/
    /*
    Ex :  YazaAay
        For Y y is present in set move forward
        For a A is present in set move forward
        For z Z is NOT present in set
            hence divide
                    YazaAy
                  /        \
                /           \
             Ya              aAay
          For y, divide     For a A is present
           /  \             For A a is present
          ""  a              For y divide
              / \             /       \
             "" ""        aAa          y
                         return aAa   / \
                                     ""  ""
     */
    public String longestNiceSubstring(String s) {
        //base case
        if (s.equals(""))
            return "";
        HashSet<Character> set = new HashSet<>();
        s.chars().forEach(c -> set.add((char) c));
        for (int i = 0; i < s.length(); i++) {
            boolean containsBothCase = set.contains(Character.toLowerCase(s.charAt(i))) && set.contains(Character.toUpperCase(s.charAt(i)));
            if (!containsBothCase) {
                String firstHalf = longestNiceSubstring(s.substring(0, i));
                String secondHalf = longestNiceSubstring(s.substring(i + 1));
                return firstHalf.length() >= secondHalf.length() ? firstHalf : secondHalf;
            }
        }
        return s; //will come here only if s is valid
    }
}
