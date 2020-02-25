package HardCashImpl;

import java.util.Scanner;

public class Hard_Cash_Impl {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = 0;
        if(sc.hasNext())
            T= sc.nextInt();
        while(--T>=0) {
            int N = 0;
            if (sc.hasNext())
                N=sc.nextInt();
            int K = sc.nextInt();
            int arr1[] = new int[N];
            for(int i=0;i<N;i++)
            {
                arr1[i]=sc.nextInt();
            }
            int temp=0;
            for(int i=0;i<N;i++)
            {
                int curr=arr1[i]+temp;
                temp=curr%K;
            }
            System.out.println(temp);
        }
    }
}
