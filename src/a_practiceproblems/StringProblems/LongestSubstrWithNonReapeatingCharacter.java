package a_practiceproblems.StringProblems;

import java.util.HashMap;

public class LongestSubstrWithNonReapeatingCharacter {
    //Test Cases:
    //Case 1: "abcabcbb" - 3
    //Case 2: "abba" - 2
    //Case 3: "tmmuzxt" - 5
    //Case 4: "bbbbbb" - 1
    public int lengthOfLongestSubstring(String s) {
        int start=0,max=0;
        if(s.length()==0)
            return max;
        if(s.length()==1)
            return 1;
        HashMap<Character,Integer> map = new HashMap<>();
        map.put(s.charAt(0),0);
        for(int i=1;i<s.length();i++)
        {
            char c = s.charAt(i);
            int len = (i-start);
            if(map.containsKey(c))
            {
                //repeating character
                int new_start = map.get(c)+1;
                if(new_start>start)
                {
                    //If the repeating chracter's last index is lesser than start...that means we are not considering it in our substring
                    //So no need to change start
                    start=new_start;
                }
            }
            max = Math.max(len,max);
            map.put(c,i);
        }
        int len = s.length()-start;
        max = Math.max(len,max);
        return max;
    }
}
