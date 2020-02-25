import java.io.StringWriter;
import java.util.Arrays;
import java.util.Scanner;

public class NoChangeRequired {
    static public void main(String... args) throws Exception {
        Scanner sc =new Scanner(System.in);
        int T =sc.hasNext()?sc.nextInt():0;
        out:while(--T>=0) {
            int N = sc.nextInt();
            int P = sc.nextInt();
            int d[] = new int[N];
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                d[i] = sc.nextInt();

                if(flag && (d[i]>P||P%d[i]!=0))
                    flag=false;
            }
            if(flag)
            {
                System.out.println("NO");
                continue out;
            }
            System.out.print("YES ");

            for(int i=0;i<N;i++)
            {
                if(P%d[i]==0)
                    continue;
                int no=(P/d[i])+1;
                int sum=d[i]*(no);
                if(sum-d[i]<P)
                {
                    for(int k=0;k<N;k++)
                    {
                        if(k==i)
                            System.out.print(no+" ");
                        else
                            System.out.print("0 ");
                    }
                    System.out.println();
                    continue out;
                }
            }
        }

    }

    static boolean calChange(int[] arr, int res[], long K, int start)
    {
        if(K==0)
            return true;
        if(K<0)
            return false;
        for(int i=arr.length-1;i>=start;i--)
        {
            if(arr[i]<=K)
            {
                /*if(arr[i]%K==0)
                {
                    res[i]+=(arr[i]/K);
                    return true;
                }*/
                res[i]+=1;
                boolean ans=calChange(arr,res,K-arr[i],start);
                if(ans)
                    return true;
                res[i]-=1;
            }
        }
        return false;
    }
}
