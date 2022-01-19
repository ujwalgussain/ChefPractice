package a_practiceproblems.ArrayProblems;

import java.util.HashMap;

public class SubArrayWithEqualNoOf0sAnd1s {
    /*Logic:
    Since we are treating 0 as -1 a sum 0 represents subarray with equal 0's and 1's
    Hence if we store the sum in map
    In each iteration the calculated sum is present in map then sum from prev idx where the sum was encountered until currIdx is 0 ie.,represents subarray with equal 0's and 1's.
     */
    int maxLen(int[] arr, int N)
    {
        //https://www.youtube.com/watch?v=1WugaISSWx8
        //https://practice.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1/
        HashMap<Integer,Integer> sumToIdxMap = new HashMap<>();
        //base case
        sumToIdxMap.put(0,-1);
        int sumUpto = 0;
        int maxLen = 0;
        for(int i=0;i<N;i++){
            sumUpto+=arr[i]==0?-1:1;
            //If Sum was encountered earlier
            if(sumToIdxMap.containsKey(sumUpto)){
                maxLen = Math.max(maxLen,i - sumToIdxMap.get(sumUpto));
            }
            else{
                sumToIdxMap.put(sumUpto,i);
            }
        }
        return maxLen;
    }
}
