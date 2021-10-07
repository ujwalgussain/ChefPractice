package a_practiceproblems.ArrayProblems.slidingwindow;

public class MinLengthSubArrayWithSumGreaterThanK {
     /* https://www.techiedelight.com/length-of-smallest-subarray-with-sum-greater-number/
    Find the smallest subarray length whose sum of elements is greater than `k`
    Example:
    Input:  {1, 2, 3, 4, 5, 6, 7, 8}, k = 20
    Output: The smallest subarray length is 3
    Explanation: The smallest subarray with sum > 20 is {6, 7, 8}

    Input:  {1, 2, 3, 4, 5, 6, 7, 8}, k = 7
    Output: The smallest subarray length is 1
    Explanation: The smallest subarray with sum > 7 is {8}

    Input:  {1, 2, 3, 4, 5, 6, 7, 8}, k = 21
    Output: The smallest subarray length is 4
    Explanation: The smallest subarray with sum > 21 is {5, 6, 7, 8}

    Input:  {1, 2, 3, 4, 5, 6, 7, 8}, k = 40
    Output: No subarray exists

     */

    public static void main(String[] args) {
        System.out.println(findSmallestSubarray(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 14));
    }

    public static int findSmallestSubarray(int[] nums, int k) {
        // Write your code here...
        int start = 0, sum = 0, minWindowSize = Integer.MAX_VALUE;
        for (int end = 0; end < nums.length; end++) {

            sum += nums[end];
            while (sum > k && start <= end) {
                minWindowSize = Math.min(minWindowSize, end - start + 1);
                sum -= nums[start++];
            }
        }
        return minWindowSize == Integer.MAX_VALUE ? 0 : minWindowSize;
    }
}
