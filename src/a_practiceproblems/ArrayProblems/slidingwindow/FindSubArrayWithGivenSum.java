package a_practiceproblems.ArrayProblems.slidingwindow;

import java.util.HashMap;
import java.util.List;

public class FindSubArrayWithGivenSum {
    /*
    Find a subarray having the given sum in an integer array


    Input:  A[] = {2, 6, 0, 9, 7, 3, 1, 4, 1, 10}, target = 15
    Output: {6, 0, 9}


    Input:  A[] = {0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10}, target = 15
    Output: {1, -4, 7, 6, 1, 4} or {4, 1, 10}


    Input:  A[] = {0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10}, target = -3
    Output: {1, -4}
    * */
    //Wrong approach : Wont work with A = [-1, -1, 1] k=0
    public static List<Integer> findSubarray(List<Integer> nums, int k) {
        // Write your code here...
        int n = nums.size();
        int start = 0, ws = 0, we = 0;
        int sum = 0;
        for (int end = 0; end < n; end++) {
            sum += nums.get(end);
            while (sum > k && start <= end) {
                sum -= nums.get(start++);
            }
            if (sum == k) {
                ws = start;
                we = end;
                break;
            }
        }
        if (ws >= we)
            return List.of();
        return nums.subList(ws, we + 1);
    }
    // Correct Approach : https://leetcode.com/problems/subarray-sum-equals-k/submissions/
    public int subarraySumCount(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //initial
        int sum = 0;
        int cnt = 0;
        for (int ele :
                nums) {
            sum += ele;
            cnt += map.getOrDefault(sum - k, 0);
            map.put(
                    sum,
                    map.getOrDefault(sum, 0) + 1
            );
        }
        return cnt;
    }


    public static void main(String[] args) {
        System.out.println(findSubarray(List.of(2, 6, 0, 9, 7, 3, 1, 4, 1, 10), 15));
    }
}
