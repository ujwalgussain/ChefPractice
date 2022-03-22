package a_practiceproblems.ArrayProblems.slidingwindow.subarrays.sum.find;

import java.util.HashMap;

public class LongestSubarrayWithZeroSum {
    static int solve(int[] num){
        HashMap<Integer,Integer> idxToSumMap = new HashMap<>();
        idxToSumMap.put(0,-1);
        int maxLen = 0;
        int sum =0;
        for (int i = 0; i < num.length; i++) {
            sum+=num[i];
            if(idxToSumMap.containsKey(sum)){
                maxLen = Math.max(maxLen,i-idxToSumMap.get(sum));
            }
            else{
                idxToSumMap.put(sum,i); //we always need the oldest value for maxLen. Hence insert only if not present
            }
        }
        return maxLen;
    }
}
