package a_practiceproblems.StringProblems.palindrome;

import java.util.HashMap;

public class CheckIfStrIsPalindromeWithOneDeleteion {
    //https://www.interviewbit.com/problems/convert-to-palindrome/
    public int solve(String A) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char a: A.toCharArray()){
            freq.put(a,freq.getOrDefault(a,0)+1);
        }
        int oddCnt=0;
        for(Integer i: freq.values()){
            if((i&1)==1)
                oddCnt++;
            if(oddCnt>1)
                return 0;
        }
        return 1;
    }
}
