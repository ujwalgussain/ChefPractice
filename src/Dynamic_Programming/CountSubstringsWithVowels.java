package Dynamic_Programming;

import java.util.HashMap;
import java.util.List;

public class CountSubstringsWithVowels {
    //https://leetcode.com/problems/count-sorted-vowel-strings/submissions/
    //static String s = "";
    public int countVowelStrings(int n) {
        return helper(0,n); //0 represents empty string, 1-a 2-e....
    }
    HashMap<String, Integer> map = new HashMap<>();
    public int helper(int i, int k) {
        String key = i+"-"+k;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int result = 1;
        //System.out.println(s);
        if (k != 0) {
            int c = 0;
            for (int j = 1; j <= 5; j++) {
                if (i <= j) {
                    //s+=j;
                    c += helper(j, k - 1);
                    //s = s.substring(0,s.length()-1);
                }
            }
            result = c;
        }
        map.put(key,result);
        return result;
    }
}
