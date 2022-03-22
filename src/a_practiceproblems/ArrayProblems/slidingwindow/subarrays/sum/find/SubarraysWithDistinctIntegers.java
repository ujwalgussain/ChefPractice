package a_practiceproblems.ArrayProblems.slidingwindow.subarrays.sum.find;

import java.util.ArrayList;

import static a_practiceproblems.ArrayProblems.slidingwindow.subarrays.sum.count.CountSubArraysWithAtmostKDistinctElements.countSubArraysWithAtmostKElements;

//Link : https://www.interviewbit.com/problems/subarrays-with-distinct-integers/
public class SubarraysWithDistinctIntegers {

    /*Problem Statement:
        Given an array A of positive integers,call a (contiguous,not necessarily distinct) subarray of A good
        if the number of different integers in that subarray is exactly B.
        (For example: [1, 2, 3, 1, 2] has 3 different integers 1, 2 and 3)
        Return the number of good subarrays of A.
        Ex :
            A = [1, 2, 1, 2, 3]
            B = 2
            Subarrays formed with exactly 2 different integers: [1, 2], [2, 1], [1, 2], [2, 3], [1, 2, 1], [2, 1, 2], [1, 2, 1, 2].
            Ans is 7
    * Logic:
    * We can get the answer by finding all sub-arrays with less than or equal to K distinct elements
    * and then removing all sub-arrays with less than or equal to K-1 elements
    * */
    public int solve(ArrayList<Integer> A, int B) {
        return countSubArraysWithAtmostKElements(A, B) - countSubArraysWithAtmostKElements(A, B - 1);
    }
}
