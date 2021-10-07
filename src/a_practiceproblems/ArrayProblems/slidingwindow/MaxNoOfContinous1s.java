package a_practiceproblems.ArrayProblems.slidingwindow;

public class MaxNoOfContinous1s {
    public static int findIndexofZero(int[] nums)
    {
        // Write your code here...
        int cnt = 0;
        int maxcnt = 0;
        for(int i:nums)
        {
            if(i==0)
                cnt=0;
            else
            {
                cnt++;
                maxcnt = Math.max(maxcnt,cnt);

            }
        }
        return maxcnt;
    }
}
