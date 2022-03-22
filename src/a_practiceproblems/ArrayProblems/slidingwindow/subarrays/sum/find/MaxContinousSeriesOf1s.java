package a_practiceproblems.ArrayProblems.slidingwindow.subarrays.sum.find;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/max-continuous-series-of-1s/
public class MaxContinousSeriesOf1s {
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        int cnt = 0, l = 0;
        int maxlen=0, maxhi=0,maxlo=0;
        for(int r = 0; r<A.size(); r++)
        {
            if(A.get(r) == 0)
            {
                cnt++;
            }
            while(cnt>B)
            {
                if(A.get(l)==0)
                    cnt--;
                l++;
            }
            int len = r - l +1;
            if(len>maxlen)
            {
                maxlo = l;
                maxhi = r;
                maxlen = len;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=maxlo; i<=maxhi;i++)
            ans.add(i);
        return ans;
    }
}
