package PracticeProblems.TreeProblems;

import java.util.Arrays;
import java.util.Scanner;

public class TreeQueriesImpl {
    static void approach1()
    {
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
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int i=-1;
        int arr[] = new int[N];
        while(++i<N)
        {
            arr[i]=sc.nextInt();
        }
        int level[][] = new int[1000][2];
        int l=1;
        while(true)
        {
            int start=level[l-1][0]+(int)Math.pow(2,l-1);
            if(start>N)
                break;
            level[l][0]=start;
            level[l][1]=start+(int)(Math.pow(2,l)-1);
            l++;
        }
        level[l-1][1]=N-1;
        int Q_arr[][]=new int[Q][4];
        i=-1;
        while(++i<Q)
        {
            Q_arr[i][0]=sc.nextInt();
            Q_arr[i][1]=sc.nextInt();
            Q_arr[i][2]=sc.nextInt();
            if(Q_arr[i][0]==3)
                Q_arr[i][3]=sc.nextInt();
        }

        i=-1;
        while(++i<Q)
        {
            int data[] = Q_arr[i];
            switch(data[0])
            {
                case 1:
                {
                    int X = data[1]-1;
                    int LV = data[2]-1;
                    System.out.println(arr[level[LV][0]+X]);
                    break;
                }
                case 2:{
                    int L = data[1]-1, R = data[2]-1;
                    int start=level[L][0],end = level[R][1];
                    int sum=0;
                    for(int k=start;k<=end;k++)
                        sum+=arr[k];
                    System.out.println(sum);
                    break;
                }
                case 3:
                {
                    int X = data[1]-1;
                    int LV = data[2]-1;
                    arr[level[LV][0]+X]=data[3];
                    break;
                }
            }
        }
    }
    public static void approach2()
    {

        // Write your code here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int i=-1;
        int arr[] = new int[N];
        while(++i<N)
        {
            arr[i]=sc.nextInt();
        }
        //int level[][] = new int[1000][2];
        int level[][]=new int[1000][];
        //int l=1;
       // int start=0,end=0;
        level[0]=new int[]{arr[0]};
        /*out:while(true)
        {
            start=end+(int)Math.pow(2,l-1);
            if(start>N)
                break;
            //level[l][0]=start;
            //level[l][1]=start+(int)(Math.pow(2,l)-1);
            end = start+(int)(Math.pow(2,l)-1);
            end = (end>N-1)?N-1:end;
            int level_arr[] = new int[(end-start)+1];
            level[l] = level_arr;
            for(int p = start,q=0;p<=end;p++,q++)
            {
                level_arr[q] = arr[p];
            }
            System.out.println("start "+ start+ " end " + end);
            l++;
        }*/
        int ptr = 0,level_ctr=0;
        while (ptr<N)
        {
            int len=(int)Math.pow(2,level_ctr);
            len = ptr+len>N-1?(N)-ptr:len;
            int a2[] = new int[len];
            int s=0;
            while(--len>=0)
            {
                a2[s++]=arr[ptr++];
            }
            level[level_ctr++] = a2;
        }
            for(int[] level_arr:level)
        {
            if(level_arr!=null)
            System.out.println(Arrays.toString(level_arr));
        }

        /*int Q_arr[][]=new int[Q][4];
        i=-1;
        while(++i<Q)
        {
            Q_arr[i][0]=sc.nextInt();
            Q_arr[i][1]=sc.nextInt();
            Q_arr[i][2]=sc.nextInt();
            if(Q_arr[i][0]==3)
                Q_arr[i][3]=sc.nextInt();
        }

        i=-1;
        while(++i<Q)
        {
            int data[] = Q_arr[i];
            switch(data[0])
            {
                case 1:
                {
                    int X = data[1]-1;
                    int LV = data[2]-1;
                    System.out.println(arr[level[LV][0]+X]);
                    break;
                }
                case 2:{
                    int L = data[1]-1, R = data[2]-1;
                    int start=level[L][0],end = level[R][1];
                    int sum=0;
                    for(int k=start;k<=end;k++)
                        sum+=arr[k];
                    System.out.println(sum);
                    break;
                }
                case 3:
                {
                    int X = data[1]-1;
                    int LV = data[2]-1;
                    arr[level[LV][0]+X]=data[3];
                    break;
                }
            }
        }*/
    }
    public static void main(String args[])
    {
        approach2();
    }
}
