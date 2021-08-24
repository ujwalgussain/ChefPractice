package a_practiceproblems.ArrayProblems.slidingwindow;

import java.util.HashMap;

public class MinimumWindowSubstring {
    /*Logic: https://leetcode.com/problems/minimum-window-substring/
        Use 2 ptrs left, right = 0
        if current window doesnt contain all characters then move right ptr and include the new element in the window
        if current window contains all characters then move the left ptr until the window doesn't satisfy the condition
    * */
    public String minWindow(String s, String t) {
        if (t.length() == 0)
            return "";
        if (t.length() == 1)
            if (s.contains(t))
                return t;
            else
                return "";

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int diff = t.length(), start = 0;
        String minString = "";
        int count;
        char c;
        for (int end = 0; end < s.length(); end++) {
            //just move right ptr
            c = s.charAt(end);
            count = map.getOrDefault(c, 0) - 1;
            map.put(c, count);
            if (count >= 0)
                diff--;
            //move left until window is satisfying
            while (diff == 0) {
                //calculate length
                if (minString.length() == 0 || minString.length() > end - start + 1) {
                    //System.out.println(s.substring(start, end + 1));
                    minString = s.substring(start, end + 1);
                }
                //move left ptr
                c = s.charAt(start++);
                count = map.get(c) + 1;
                map.put(c, count);
                if (count > 0)
                    diff++;
            }
        }
        return minString;
    }
}
