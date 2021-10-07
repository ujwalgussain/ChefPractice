package a_practiceproblems.ArrayProblems.slidingwindow;

import java.util.List;

public class FindMinSumSubArrayOfSizeK {
    //Link :https://www.techiedelight.com/find-minimum-sum-subarray-given-size-k/
    public static List<Integer> findMinSumSubarray(List<Integer> A, int k)
    {
        // Write your code here...
        if(k>A.size())
        {
            return A;
        }
        int sum = 0;
        for(int i=0;i<k;i++)
        {
            sum+=A.get(i);
        }
        int l=0;
        int min = sum;
        int ws = 0, we = k-1;
        for(int i=k;i<A.size();i++)
        {
            sum+=A.get(i)-A.get(l++);
            if(sum<min)
            {
                min =sum;
                ws = i-k;
                we= i;
            }
        }
        return A.subList(ws,we+1);

    }
}
