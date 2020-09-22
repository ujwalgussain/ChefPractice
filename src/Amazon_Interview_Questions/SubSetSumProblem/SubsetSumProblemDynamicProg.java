package Amazon_Interview_Questions.SubSetSumProblem;

import java.util.Arrays;
import java.util.HashSet;

public class SubsetSumProblemDynamicProg {
    static boolean solveUsingDP(int a[], int sum)
    {
        int rows=(sum)+1,cols=a.length+1;
        boolean dp[][] = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dp[i][0]=false;
        }

        for (int i = 0; i < cols; i++) {
            dp[0][i]=true;
        }
        for(int i=1;i<rows;i++)
        {
            for (int j = 1; j < cols; j++) {
                dp[i][j]=dp[i][j-1];
                if(i>=a[j-1])
                {
                    dp[i][j]= dp[i][j] || dp[i-a[j-1]][j-1];
                }
            }
        }
        for(boolean i[] : dp)
        {
            System.out.println(Arrays.toString(i));
        }
        //printSolution(dp,a);
        return dp[rows-1][cols-1];

    }
    /*static void printSolution(boolean dp[][], int arr[])
    {
        int i= dp.length-1,j=dp[0].length-1;
        HashSet<Integer> set = new HashSet<>();
        while(i>=0) {
            if (dp[i - arr[j - 1]][j - 1]) {
                set.add(arr[j - 1]);
                i = i - arr[j - 1];
                j = j - 1;
            } else {
                j = j - 1;
            }
        }
        System.out.println(set);
    }*/
    static boolean recursiveApproach(int a[], int idx,int sum)
    {
        if(sum==0)
            return true;
        if(idx<0)
            return false;
        if(a[idx]>sum)
            return recursiveApproach(a,idx-1,sum);
        return recursiveApproach(a,idx-1,sum-a[idx]) || recursiveApproach(a,idx-1,sum);
    }
    public static void main(String[] args) {
        int a[] = {1,5,5,11};
        solveUsingDP(a,11);
        System.out.println(recursiveApproach(a,3,11));
    }
}
