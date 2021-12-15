package a_practiceproblems.ArrayProblems;

import java.util.LinkedList;

public class SumOfAllSubarrayMinimum {
    //https://leetcode.com/problems/sum-of-subarray-minimums/submissions/
    public int solve(int arr[]) {
        int N = arr.length;
        int MOD = 1000000007;
        LinkedList<Integer> queue = new LinkedList<>();
        long result = 0;
        for (int i = 0; i < N; i++) {
            while (!queue.isEmpty() && arr[queue.peekLast()] > arr[i]) {
                int pkIdx = queue.pollLast();
                int startIdx = queue.isEmpty() ? -1 : queue.peekLast();
                //arr[pkIdx] will be minimum of [i-pkIdx * pkIdx-startIdx] subarrays
                result = (result + ((long) arr[pkIdx] % MOD * (long) (i - pkIdx) % MOD * (long) (pkIdx - startIdx) % MOD)) % MOD;
            }
            queue.offerLast(i);
        }
        while (!queue.isEmpty()) {
            int pkIdx = queue.pollLast();
            int startIdx = queue.isEmpty() ? -1 : queue.peekLast();
            result = (result + ((long) arr[pkIdx] % MOD * (long) (N - pkIdx) % MOD * (long) (pkIdx - startIdx) % MOD)) % MOD;
        }
        return (int) result % MOD;
    }
}
