package StrangeNumbers;

import java.util.Arrays;
import java.util.Scanner;

public class Impl {
    static int primenos[] = new int[20000000];
    static int end=-1;
    public static void add(int K)
    {
        System.out.println("Adding");
        if(K>primenos[end])
        {
            for(int i=primenos[end]+1;i<=K;i++)
            {
                int half = i/2;
                boolean isPrime=true;
                for(int j=0;j<=end;j++)
                {
                    if(primenos[j]>half)
                        break;
                    if(i%primenos[j]==0) {
                        isPrime = false; break;
                    }
                }
                if(isPrime) {
                    System.out.println(i);
                    primenos[++end] = i;
                }
            }
        }
    }
    public static void generatePrimeNos()
    {
        primenos[++end]=2;
        for(int i=3;i<=10000;i+=2)
        {
            int half = i/2;
            boolean isPrime=true;
            for(int j=0;j<=end;j++)
            {
                if(primenos[j]>half)
                    break;
                if(i%primenos[j]==0) {
                    isPrime = false; break;
                }
            }
            if(isPrime) {
                System.out.println(i);
                primenos[++end] = i;
            }
        }
        //System.out.println(Arrays.toString(primenos));
    }

    public static void main(String args[])
    {
        //generatePrimeNos();
        Scanner sc = new Scanner(System.in);
        int T = 0;
        if (sc.hasNext())
        {
            T = sc.nextInt();
        }
        while(--T>=0)
        {
            int X = sc.nextInt(), K=sc.nextInt();
            if(K>X/2) {
                System.out.println(0); continue;
            }
            if(K==1)
            {
                System.out.println(1);continue;
            }
            if(m1(X,K))
                System.out.println(1);
            else
                System.out.println("0");
        }
    }
    public static  boolean m1(int X, int K)
    {
        int c=0;
        while(X%2==0)
        {
           // System.out.println(2);
            X=X/2;
            c++;
            if(c>=K)
                return true;

        }
        int sqrt= (int)Math.sqrt(X);
        for(int i=3;i<sqrt;i+=2)
        {
                while(X%i==0)
                {
                    //System.out.println(i);
                    X=X/i;
                    c++;
                    if(c>=K)
                        return true;
                }
        }
        if(X>2)
        {
               // System.out.println(X);
                c++;
        }
        if(c>=K)
            return true;
        return false;
    }
}
