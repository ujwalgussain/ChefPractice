import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TestClass {
    public static int findPeakElement(int[] a)
    {
        // Code here
        int lo=0, hi=a.length-1;
        System.out.println("lo"+"\t\t\t"+"mid"+"\t\t\t"+"hi");
        while(lo<=hi)
        {
            int mid=(lo+hi)/2;
            System.out.println(String.format("a[%d]=%d\t\ta[%d]=%d\t\ta[%d]=%d",lo,a[lo],mid,a[mid],hi,a[hi]));
            if(a[mid]>a[mid+1] && a[mid-1]<a[mid])
                return a[mid];
            else
            if(a[mid]>a[mid+1])
            {
                //go left
                hi=mid-1;
            }
            else
            {
                lo=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(Integer.hashCode(21));
            }
}
