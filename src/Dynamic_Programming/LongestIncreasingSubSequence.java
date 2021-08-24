package Dynamic_Programming;

import java.util.Arrays;

public class LongestIncreasingSubSequence {
    public static int lis(final int[] A) {
        int n = A.length;
        int[] lis = new int[n];
        Arrays.fill(lis,1);
        int max_lis=1;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(A[i]>A[j])
                {
                    lis[i] = Math.max(lis[i],lis[j]+1);
                    max_lis = Math.max(lis[i],max_lis);
                }
            }
        }
        return max_lis;
    }

    public static void main(String[] args) {
        System.out.println(lis(new int[]{1,3,5}));
    }
}
