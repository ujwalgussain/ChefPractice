package Reunionof1s;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here

        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int K = sc.nextInt();
        char arr[] = sc.next().toCharArray();
        int[][] q = new int[K][2];
        for(int i=0;i<K;i++)
        {
            q[i][0]=sc.nextInt();

            if(q[i][0]==2)
            {
                q[i][1]=sc.nextInt();
            }
        }
        for(int i=0;i<K;i++)
        {
            if(q[i][0]==2)
            {
                arr[q[i][1]-1]='1';
            }
            else
            {
                System.out.println(getMaxLength(arr));
            }
        }


    }
    static int getMaxLength(char[] arr)
    {
        int max_so_far=0,max_ending_here=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]=='1')
            {
                max_ending_here++;
            }
            else
            {
                max_ending_here=0;
            }
            if(max_ending_here>max_so_far)
            {
                max_so_far=max_ending_here;
            }
        }
        return max_so_far;
    }
    /*static int getMaxLength(char arr[], int low, int high)
    {
        if(low==high)
        {
            if(arr[low]=='1')
            {
                return 1;
            }
            return 0;
        }
        int mid = (low+high)/2;
        getMaxLength(arr,low,mid);
        getMaxLength(arr,mid+1,high);
        getCrossMaxLength(arr,low,mid,high);
    }*/

    /*static int getCrossMaxLength(char arr[], int low, int mid, int high)
    {
        int left_max=
        int right_max=
        int cross_max=
    }*/

}
