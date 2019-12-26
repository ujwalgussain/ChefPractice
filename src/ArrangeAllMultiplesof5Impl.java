import java.util.Arrays;

public class ArrangeAllMultiplesof5Impl {
    static void X5arrange(int a[])
    {
        int count=0;
        int ptr1 = 0;
        while(count < a.length)
        {
            int current = a[ptr1];
            System.out.printf("ptr1 %d current = %d\n", ptr1,current);
            if(current%5==0)
            {
                //leftshift from ptr1
                leftShiftAndPut(a,ptr1);
                a[a.length-1] = current;
                System.out.println("After Replace " + Arrays.toString(a));
                count++;
                continue;
            }
            ptr1++;count++;
        }
    }
    static void leftShiftAndPut(int a[], int ptr)
    {
        for(int i=ptr;i<a.length-1;i++)
        {
            a[i]=a[i+1];
        }
    }
    static public void main(String a[])
    {
        int arr[] = new int[]{2,4,8,5,12,15,6,10,7,30,25,43,46,45,21};
        X5arrange(arr);
        System.out.println(Arrays.toString(arr));
    }
}
