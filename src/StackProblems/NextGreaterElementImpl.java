package StackProblems;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementImpl {
    /*
    * If stack is Empty -> just push
    * Else
    *   pop until the current > top and hence current becomes NGE for all elements popped*/
    public static void main(String args[] ) throws Exception {

        // Write your code here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long arr[]=new long[N];
        for(int i=0;i<N;i++)
        {
            arr[i]=sc.nextLong();
        }
        int nge[] = new int[N];
        int nse[] = new int[N];
        Stack<Integer> s1 = new Stack<>();

        Stack<Integer> s2 = new Stack<>();
        for(int i=0;i<N;i++)
        {
            processNGE(i,arr,nge,s1);
            processNSE(i,arr,nse,s2);
        }
        System.out.printf("%s\t%s\t%s\t%s\t%s\n","arr[i]","G(i)","F(i)","nge","nse");
        for(int i=0;i<N;i++)
        {
            //System.out.println(((nge[i]!=-1)&&nse[nge[i]]!=-1?arr[nse[nge[i]]]:-1 )+ " ");
            System.out.printf("%d    \t%d   \t%d   \t%d   \t%d\n",arr[i],
                    (nge[i]!=-1)?arr[nge[i]]:-1,
                    (nge[i]!=-1)&&(nse[nge[i]]!=-1)?arr[nse[nge[i]]]:-1,nge[i],nse[i]);
        }
    }
    static void processNGE(int i,long[] arr, int[] nge, Stack<Integer> stack)
    {
        while(!stack.isEmpty() && arr[i]>arr[stack.peek()])
        {
            System.out.println("max i = "+i);
            nge[stack.pop()]=i;
        }
        stack.push(i);
        nge[i]=-1;
    }
    static void processNSE(int i,long[] arr, int[] nse, Stack<Integer> stack)
    {
        while(!stack.isEmpty() && arr[i]<arr[stack.peek()])
        {
            System.out.println("min i = "+i + "stack "+stack);
            nse[stack.pop()]=i;
        }
        stack.push(i);
        nse[i]=-1;
    }
}
