package SimilarElementsHackerEarth;

import java.util.Arrays;

public class FindSimilarElemImpl {
    static long SimilarElementsPairs(int[] A,int N){
        // Write your code here
        Arrays.sort(A);
        long c=0,res=0;boolean f=false;
        for(int i=1;i<N;i++)
        {
            long ans = A[i]-A[i-1];
            if(ans<=1)
            {
                c=c==0?2:c+1;
                if(ans==1)
                    f = true;
            }
            else
            {
                if(f)
                {
                    res = res + ((c*(c-1))/2);

                }
                f=false;c=0;
            }
        }
        if(f)
        {
            res = res + ((c*(c-1))/2);
        }
        return res;
    }

}
