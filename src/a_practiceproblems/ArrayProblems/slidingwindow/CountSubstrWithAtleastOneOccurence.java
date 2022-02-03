package a_practiceproblems.ArrayProblems.slidingwindow;

import java.util.HashMap;

public class CountSubstrWithAtleastOneOccurence {
    //https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
    /*
    Ex: aaabccaa
    Scan each char until we find one occurence of a,b,c ie., aaabc
    All Substrings ending at 4th idx have atleast one occurence
        from end -> aaabc, aaabcc, aaabcca, aaabccaa
        from start -> aabc, abc
     */

    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int count = 0;
        int j = 0;
        int len = s.length();
        while (j < len) {
            char endChar = s.charAt(j);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            while (map.size() == 3) {
                //count all substrings

                //all substrings starting with substring from start to j
                //Ex: aabcaa -> for aabc -> all substrings starting with aabc ie., aabca , aabcaa
                count += len - j;

                //check all substring ending with substring until j
                //Ex:aaabcaa -> for aaabc -> aabc,abc
                char startChar = s.charAt(start++);
                int x = map.get(startChar);
                if (x == 1)
                    map.remove(startChar);
                else
                    map.put(startChar, x - 1);
            }
            j++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(new CountSubstrWithAtleastOneOccurence().numberOfSubstrings("abcabc"));
    }
}
