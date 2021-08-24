package a_practiceproblems.ArrayProblems.triplets;

import java.util.Arrays;

public class TripletsWithSumLessThanK {
    static void find(int[] A, int k)
    {
        Arrays.sort(A);
        int ans = 0;
        for(int i=0;i<A.length-2;i++)
        {
            int lo = i+1,hi= A.length-1;

            while(lo<hi)
            {
                int sum = A[i] + A[lo] + A[hi];
                if(sum > k)
                    hi--;
                else
                {
                    ans+=(hi-lo);
                    lo++;
                }
            }
        }
        System.out.println("Found - "+ans);
    }

    public static void main(String[] args) {
        find(new int[]{1,2,3,4,5,6},7);
    }
}
