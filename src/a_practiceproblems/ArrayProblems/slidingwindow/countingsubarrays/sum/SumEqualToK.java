package a_practiceproblems.ArrayProblems.slidingwindow.countingsubarrays.sum;

import java.util.HashMap;

public class SumEqualToK {
    //Hashing Tech
    //https://leetcode.com/problems/subarray-sum-equals-k/submissions/
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> sumCountMap = new HashMap<>();
        int sum = 0;
        int cnt = 0;
        for(Integer i : nums){
            sum+=i;
            if(sum==k)
                cnt++;
            cnt+=sumCountMap.getOrDefault(sum-k,0);
            sumCountMap.put(sum, sumCountMap.getOrDefault(sum,0)+1);
        }
        return cnt;
    }

    public int subarraySumWithhoutHashing(int[] nums, int k) {//This wont work with negatives
        int result = 0;//to store ans
        int sum = 0;//to keep track of window sum
        int size = nums.length;
        int start = 0;//left end of the window
        for (int end = 0; end < size; ++end) {
            sum += nums[end];
            while (sum > k) {//if sum is more start deducting from left
                sum -= nums[start++];
            }
            if(sum==k)
                result += end - start + 1;//nC2  ways or no of subarray with i as end and left as starting
        }
        return result;
    }
}
