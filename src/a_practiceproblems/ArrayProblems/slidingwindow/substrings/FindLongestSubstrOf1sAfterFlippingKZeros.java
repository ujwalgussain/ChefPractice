package a_practiceproblems.ArrayProblems.slidingwindow.substrings;

public class FindLongestSubstrOf1sAfterFlippingKZeros {
    int findlongestSubArray(int[] nums, int k) {
        int start = 0;
        int zeroCnt = 0;
        int maxV = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            while (zeroCnt > k) {
                if (nums[start] == 0)
                    zeroCnt--;
                start++;
            }
            if (nums[i] == 0) {
                zeroCnt++;
            }
            if (zeroCnt <= k) {
                maxV = Math.max(maxV, i - start + 1);
            }
        }
        return maxV;
    }
}
