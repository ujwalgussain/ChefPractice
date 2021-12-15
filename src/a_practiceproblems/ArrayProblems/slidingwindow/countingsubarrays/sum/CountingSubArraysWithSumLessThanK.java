package a_practiceproblems.ArrayProblems.slidingwindow.countingsubarrays.sum;

import java.util.ArrayList;

public class CountingSubArraysWithSumLessThanK {
    //https://www.interviewbit.com/problems/counting-subarrays/
    public static int lessThanK(ArrayList<Integer> A, int B) {
        int result = 0;//to store ans
        int sum = 0;//to keep track of window sum
        int size = A.size();
        int start = 0;//left end of the window
        for (int end = 0; end < size; ++end) {
            sum += A.get(end);
            while (sum >= B && start <= end) {//if sum is more start deducting from left
                sum -= A.get(start++);
            }
            result += end - start + 1;//nC2  ways or no of subarray with i as end and left as starting
        }
        return result;
    }
}
