package Amazon_Interview_Questions;

public class MaxSubArraySumWithNonConsecutiveElements {
    //https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
    public static void main(String[] args) {
        int a[] = {3,2,7,10};
        {
            int incl=a[0],excl=0,excl_new=0;
            System.out.printf("");
            for (int i = 1; i < a.length; i++) {
                excl_new = Math.max(incl,excl);
                incl = excl+a[i];
                excl=excl_new;
            }
            System.out.println(Math.max(incl,excl));
        }


    }
    public static int bf(int start, int[] a)
    {
        if(start>=a.length)
            return 0;
        int max = 0;
        for (int i = start; i < a.length; i++) {
            int ans = bf(i+2,a) + a[i];
            max = Math.max(max,ans);
        }
        return max;
    }
}
