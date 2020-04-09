import java.util.Arrays;

public class SieveOfErastothenes {

    public static int[] getPrimeNumbers(int N)
    {
        boolean isComposite[] = new boolean[1000000000];
        int arr[] = new int[60000000];
        int end=-1;
        int c=0;
        for(int i=2;i<isComposite.length;i++)
        {
            if(!isComposite[i])
            {
                arr[++end]=i;
                if(end==N-1)
                    break;
                int k;
                for(int j=2;(k=i*j)<isComposite.length;j++)
                {
                    isComposite[k]=true;
                }
            }
        }
        return Arrays.copyOfRange(arr,0,end+1);
    }

    static public void printPrimeNosTillN(int N)
    {
        //We know that all even nos cannot be prime.. Hence we consider only odd Nos
        int primes[] = new int[20000];
        int end=-1;
        primes[++end]=2;
        for(int i=3; i<N;i=i+2)
        {
            int half = i/2;
            boolean isPrime=true;
            for(int j=0;j<=end;j++)
            {
                if(primes[j]>half)
                    break;
                if(i%primes[j]==0)
                {
                    isPrime=false;
                    break;
                }
            }
            if(!isPrime)
                primes[++end]=i;
        }
    }
    public static void main(String args[])
    {

    }
}
