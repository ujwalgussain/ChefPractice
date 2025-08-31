package Amazon_Interview_Questions.SubSetSumProblem;

import java.util.Arrays;

public class SubsetSumProblemDynamicProg {
    /*
    Min Coin change [Infinite supply of coins]
    public int minCoins(int coins[], int sum) {
        // code here
        int dp[] = new int[sum+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;  ----> Base Case
        for(int coin: coins) {
            for(int i=coin; i<=sum;i++) {
                if(dp[i-coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return dp[sum]==Integer.MAX_VALUE ? -1: dp[sum];
    }

    */
    //Find Subset Sum
    //More Optimized approach
    public boolean hasSubsetWithSum(int[] nums, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // base case --->

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
    /*
    In coin change we have infinite supply
    in subset sum, we take only once.
    Hence in coin change we have inner loop going from num to target
    and in subset we go reverse, target to num
         base case dp[0]=1
     */


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

    //This approach will only find if there exists a subset with sum and not K subsets with equal sum
    static boolean findSubsetWithSum(int a[], int idx, int sum)
    {
        if(sum==0)
            return true;
        if(idx<0)
            return false;
        if(a[idx]>sum)
            return findSubsetWithSum(a,idx-1,sum);
        return findSubsetWithSum(a,idx-1,sum-a[idx]) || findSubsetWithSum(a,idx-1,sum);
    }
    public static void main(String[] args) {
        int a[] = {6,2};
        //solveUsingDP(a,11);
        //System.out.println(recursiveApproach(a,3,11));
        System.out.println(PartitionSubset.intoKPartsWithEqualSum_DP(new int[]{1,2,2,2,1}, 4));

    }

    static class PartitionSubset
    {
        static boolean visited[] = new boolean[5];

        static boolean intoKPartsWithEqualSum_Rec(int set[], int k)
        {
            int sum = Arrays.stream(set).sum();
            if(sum%k != 0)
                return false;
            return solve(set,0,k,0,sum/k);

        }
        private static boolean solve(int v[] , int idx, int k, int cur, int target)
        {
            if(k==1)
                return true;
            if(cur>target)
                return false;
            if(cur==target)
                return solve(v,0,k-1,0,target);
            for(int i=idx;i<v.length;i++)
            {
                if(!visited[i])
                {
                    visited[i]=true;
                    if(solve(v,i+1,k,cur+v[i],target))
                        return true;
                    visited[i]=false;
                }

            }
            return false;
        }
        static boolean intoKPartsWithEqualSum_DP(int set[], int k)
        {
            int sum = Arrays.stream(set).sum();
            if(sum%k != 0)
                return false;
            return solveUsingDP(set,k);

        }
        private static boolean solveUsingDP(int set[], int K)
        {
            int rows = K+1, cols = set.length +1;
            int dp[][] = new int[rows][cols];
            for(int i = 0;i<rows ;i++)
                dp[i][0]=0;
            for(int i = 0;i<cols ;i++)
                dp[0][i]=1;
            for(int i=1;i<rows;i++)
            {
                for(int j=1;j<cols;j++)
                {
                    dp[i][j] = dp[i][j-1];
                    if(i>=set[j-1])
                        dp[i][j] += dp[i-set[j-1]][j-1];
                }
            }
            System.out.println(Arrays.toString(dp[rows-1]));
            return dp[rows-1][cols-1]==K;
        }
    }
}