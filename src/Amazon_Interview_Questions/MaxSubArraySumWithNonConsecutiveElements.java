package Amazon_Interview_Questions;

public class MaxSubArraySumWithNonConsecutiveElements {
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
        {
            int incl=a[0],excl=0,excl_new=0;

            for (int i = 1; i < a.length; i++) {
                excl_new = Math.max(incl,excl);
                incl = excl+a[i];
                excl=excl_new;
            }
            System.out.println(Math.max(incl,excl));
        }


    }
}
