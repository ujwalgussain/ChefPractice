import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ChefAndMaxStarValue {
    /*  PROBLEM STATEMENT
        You are given a sequence A1,A2,…,AN. For each valid i, the star value of the element Ai is the number of valid indices j<i such that Aj is divisible by Ai.

        Chef is a curious person, so he wants to know the maximum star value in the given sequence. Help him find it.

        Input
        The first line of the input contains a single integer T which denotes the number of test cases.
        The first line of each test case contains a single integer N .
        The second line of each test case contains N space-separated integers A1,A2,…,AN.
        Output
        For each test case, print a single line containing one integer ― the maximum star value.
        Example Input
        1
        7
        8 1 28 4 2 6 7
        Example Output
        3
        Explanation
        A5=2 divides 4, 28 and 8, so its star value is 3. There is no element with a higher star value.*/
   /* static int getMaxStarValue(int pivot, int[] arr) {
        if (pivot == 0)
            return 0;
        int starValue = 0;
        for (int i = 0; i < pivot; i++) {
            if (arr[i] % arr[pivot] == 0)
                starValue++;
        }
        return Math.max(starValue, getMaxStarValue(pivot - 1, arr));
    }*/

    /*static public void main(String args[])
    {
        int testCase = 0;
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext())
            testCase=sc.nextInt();
        int i=-1;
        while(++i<testCase)
        {
            int N = 0;
            if(sc.hasNext())
                N= sc.nextInt();
            int arr[]= new int[N];
            int j = -1;
            while(++j<N)
            {
                if(sc.hasNext()) {
                    arr[j] = sc.nextInt();
                }
            }
            System.out.println(getMaxStarValue(arr.length-1,arr));
        }
    }*/

    static void solution2(int n, int a[])
    {
        int  i ,j;
        int count = 0 , ans = 0;
        int max = 0;
        for(i = 0 ; i < n ; i++)
            if(a[i] > max)
                max = a[i];
        System.out.println("Max " + max);

        for(i = n-1 ; i > -1 ; i--){
            count = 0;
            if(a[i] < 85 )
                for(j = 0 ; j < i ; j++)
                {
                    if(a[j] % a[i] == 0)
                        count++;
                }
            if(count > ans)
                ans = count ;
            if(count > 12000)
                break;
        }
        System.out.printf("%d\n",ans);
    }


    static public void main(String... args)
    {
            int testCase = 0;
            Scanner sc = new Scanner(System.in);
            if (sc.hasNext())
                testCase = sc.nextInt();
            int i = -1;
            while (++i < testCase) {
                int N = 0;
                if (sc.hasNext())
                    N = sc.nextInt();
                int arr[] = new int[N];
                int b[] = new int[N];
                int j = -1;
                while (++j < N) {
                    if (sc.hasNext()) {
                        arr[j] = sc.nextInt();
                        if (arr[j]<100)
                            b[arr[j]-1] = j;
                    }
                }
                int maxStarValue=0;
                /*for(int k=arr.length-1;k>=1;k--)
                {
                    int current = arr[k];
                    int current_StarValue = 0;
                    if(maxStarValue>=k-1)
                    {
                        System.out.println("Stop ");
                        break;
                    }
                    for(int l = 0; l<k;l++)
                    {
                        System.out.printf("\t%d %% %d\n",arr[l],current);
                        if(arr[l]>current && arr[l]%current==0)
                        {
                            current_StarValue++;
                        }
                    }
                    maxStarValue = Math.max(current_StarValue,maxStarValue);
                }*/
                for(int k=0;k<100;k++)
                {

                }
                System.out.println(maxStarValue);
            }
    }
}
