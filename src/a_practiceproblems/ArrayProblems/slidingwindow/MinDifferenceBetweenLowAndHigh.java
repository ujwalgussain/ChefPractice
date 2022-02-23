package a_practiceproblems.ArrayProblems.slidingwindow;

import java.util.Arrays;

public class MinDifferenceBetweenLowAndHigh {
    //https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/submissions/
    /*
    Goal is to find min Difference between min and max elements of a window of size k.
    best way is to sort the array and then find min Value between start and end of the window

     */
    public int minimumDifference(int[] nums, int k) {
        if(k<=1)
            return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i=k-1;i<nums.length;i++){
            min = Math.min(min,nums[i]-nums[i-k+1]);
        }
        return min;
    }
}
