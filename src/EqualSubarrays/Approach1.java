package EqualSubarrays;

import java.util.Scanner;

public class Approach1 {
    class SegmentTree{
        int tree[]; int N;
        void build(int arr[])
        {
            N=arr.length;
            int x = (int)Math.ceil(Math.log(N)/Math.log(2));
            int len =2*(int)Math.pow(2,x);
            tree = new int[len];
            buildTree(arr,1,0,N-1);
        }
        int query(int qs, int qe)
        {
            return query(1,0,N-1,qs,qe);
        }
        void buildTree(int arr[], int idx, int s, int e)
        {
            if(s==e)
                tree[idx]=arr[s];
            else{
                int mid=(s+e)/2;
                int left=idx<<1,right=left+1;
                buildTree(arr,left,s,mid);
                buildTree(arr,right,mid+1,e);
                tree[idx]=Math.max(tree[left],tree[right]);
            }
        }
        int query(int idx, int ss, int se, int qs, int qe)
        {
            if(qs<=ss && se<=qe)
                return tree[idx];

            if(qe<ss || se<qs)
                return 0;

            int mid=(ss+se)/2;
            int left=idx<<1,right=left+1;
            return Math.max(query(left,ss,mid,qs,qe),query(right,mid+1,se,qs,qe));
        }
    }
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
        int arr[] = new int[N];
        for(int i=0;i<N;i++)
            arr[i]=sc.nextInt();
        SegmentTree stree = new Approach1().new SegmentTree();
        stree.build(arr);
        for(int i=N;i>0;i--)
        {
            int e=i-1;
            while(e<=N-1)
            {
                int s=e-(i-1);
                if(find(arr,s,e,K,stree))
                {
                    System.out.println(i);
                    return;
                }
                e++;
            }
        }
    }
    static boolean find(int arr[], int s, int e, int K,SegmentTree stree)
    {
        /*int max=Integer.MIN_VALUE;*/
        /*for(int i=s;i<=e;i++)
            max=Math.max(max,arr[i]);*/
        int max = stree.query(s,e);
        int sum=0;
        for(int i=s;i<=e;i++){
            sum=sum+(max-arr[i]);
            if(sum>K)
                return false;
        }
        if(sum>K)
            return false;
        return true;
    }
}
