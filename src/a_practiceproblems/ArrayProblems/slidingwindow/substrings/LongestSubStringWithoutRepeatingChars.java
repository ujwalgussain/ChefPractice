package a_practiceproblems.ArrayProblems.slidingwindow.substrings;

import java.util.HashSet;

public class LongestSubStringWithoutRepeatingChars {
    public static int findLength(String s)
    {
        HashSet<Character> set = new HashSet<>();
        int start=0,ans=0;
       for(int end=0;end<s.length();end++)
       {
           char c = s.charAt(end);
           while(set.contains(c))
           {
               set.remove(s.charAt(start++));
           }
           set.add(c);
           ans = Math.max(ans,end+1-start);
       }
       return ans;
    }

    public static void main(String[] args) {
        System.out.println(findLength("abcabcbb"));
    }
}
