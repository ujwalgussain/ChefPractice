package ChefProblems;

import java.util.Arrays;
import java.util.Scanner;

class ChefAndMobileProblemImpl
{
    static class Min_SegmentTree
    {
        int tree[],arr[];
        int getLen(int len)
        {
            int a=2;
            while(a<len)
                a<<=1;

            return (2*a-1)+1;
        }
        Min_SegmentTree(int arr[])
        {
            tree=new int[getLen(arr.length)];
            this.arr=arr;
            initialize_ST();
            // System.out.println("len " + tree.length);
            buildTree(arr,1,0,arr.length-1);
        }
        void initialize_ST()
        {
            int i=0;
            while(++i<tree.length)
                tree[i]=Integer.MAX_VALUE;
        }
        void buildTree(int[] arr,int node, int ss, int se)
        {
            if(ss==se)
            {
                //  System.out.printf("tree[%s] = %s\n",node,arr[ss]);
                tree[node] = arr[ss];
            }
            else
            {
                int mid = (ss+se)/2;
                buildTree(arr, 2*node,ss,mid);
                buildTree(arr,2*node+1,mid+1,se);
                tree[node] = Math.min(tree[2*node],tree[2*node+1]);
            }
        }
        int getMinInRange(int qs, int qe)
        {
            return getMinInRange(0,arr.length-1,qs,qe,1);
        }
        private int getMinInRange(int ss,int se,int qs,int qe,int node)
        {
            // System.out.printf("ss-%s, se-%s, node-%s\n",ss,se,node);
            if(qs<=ss&&se<=qe) {
                ///System.out.printf("return tree[%s] = %s \n", node,tree[node]);
                return tree[node];
            }
            if(se<qs||ss>qe){
                // System.out.println("Return "+ Integer.MAX_VALUE);
                return Integer.MAX_VALUE;
            }
            int mid = (ss+se)/2;
            //System.out.println("Mid " + mid);
            // System.out.printf("ss-%s, se-%s, node-%s, mid-%s\n",ss,se,node,mid);
            int a1 = getMinInRange(ss,mid,qs,qe,2*node);
            int a2 = getMinInRange(mid+1,se,qs,qe,2*node+1);
            // System.out.printf("Min(%s,%s)\n",a1,a2);
            return Math.min(a1,a2);
        }
        void displayTree()
        {
            System.out.println(Arrays.toString(tree));
        }


    }
    static int getResult(int arr[])
    {
        Min_SegmentTree ms = new Min_SegmentTree(arr);
       // System.out.println(Arrays.toString(ms.tree));
        int goodprice=arr[0];
        int res = 1;
        for(int i=1;i<arr.length;i++)
        {
            int start = i-5;
            if(start<0)
                start=0;
           // System.out.printf("Range %d(%d) - %d(%d) > %d (%d) ",start,arr[start],i-1,arr[i-1],i,arr[i]);
            if(ms.getMinInRange(start,i-1)>arr[i]) {
                //System.out.printf("Good Price %d",arr[i]);
                res++;
            }
           // System.out.println();
        }
        return res;
    }
    public static void main (String[] args) throws java.lang.Exception
    {
// your code goes here
        Scanner sc = new Scanner(System.in);

        int testCase = 0;
        if(sc.hasNext())
            testCase = sc.nextInt();
        for(int i =0; i<testCase; i++)
        {
            int N = 0;
            if(sc.hasNext())
                N = sc.nextInt();
            int j=-1;
            int arr[] =new int[N];
            while(++j<N)
            {
                if(sc.hasNext())
                    arr[j] = sc.nextInt();
            }
            System.out.println(getResult(arr));
        }

    }
}
