package a_practiceproblems.ArrayProblems.slidingwindow.subarrays.sum.count;

import java.util.ArrayList;

public class CountSubArraysWithAtmostKDistinctElements {

    /*
    Problem Statement: Count All Subarrays with Distinct Elements less Than or Equal to K
    Ex: 5 3 5 1 3
        Sub arrays
    Logic :
        For any window starting from l and ending at r, no of subArrays added after including r will be r+l-1;
        ex :
        1 2 3
        For 1 [1]
        for 2 [1], [1,2], [2]
        For 3 [1], [1,2], [2], [1,2,3], [2,3], [3]

    * */

    public static int countSubArraysWithAtmostKElements(ArrayList<Integer> A, int K)
    {
        int start=0, distinct=0,total=0;
        int[] frequency = new int[40001];//Assuming A[i]<=40000

        for(int end=0;end<A.size();end++)
        {
            int currElement = A.get(end);
            if(frequency[currElement]==0)
                distinct++;
            frequency[currElement]++;
            if(distinct>K)
            {
                while(start<=end && distinct>K)
                {
                    int x = --frequency[A.get(start)];
                    if(x==0)
                        distinct--;
                    start++;
                }

            }
            total+=end+1-start;
        }
        return total;
    }
}
