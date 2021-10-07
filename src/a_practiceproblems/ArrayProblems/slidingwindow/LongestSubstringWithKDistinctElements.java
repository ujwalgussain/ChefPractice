package a_practiceproblems.ArrayProblems.slidingwindow;

import java.util.HashMap;

public class LongestSubstringWithKDistinctElements {
    static int get(String str, int k)
    {
        char[] arr = str.toCharArray();
        HashMap<Character,Integer> freq = new HashMap<>();
        int start = 0;
        int maxlen = -1;
        for (int end = 0; end < arr.length; end++) {
            char currChar = arr[end];
            freq.put(currChar, freq.getOrDefault(currChar,0)+1);
            //after adding the element, stabilize the window
            while(freq.size()>k)
            {
                char startChar = arr[start];
                int x = freq.get(startChar);
                if(x-1==0)
                    freq.remove(startChar);
                else
                    freq.put(startChar,x-1);
                start++;
            }
            //once the window is stabilized
            //If only k chars -> check if map.size()==k then
            maxlen = Math.max(maxlen,end-start+1);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        System.out.println(get("abcbdbdbbdcdabd",2));
    }
}
