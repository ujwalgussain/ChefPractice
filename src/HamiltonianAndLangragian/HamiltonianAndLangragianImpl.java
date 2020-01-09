package HamiltonianAndLangragian;

import java.util.Scanner;

public class HamiltonianAndLangragianImpl {
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
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int x = (int)Math.ceil(Math.log(n)/Math.log(2));
        int tree[] = new int[(int)(2*(Math.pow(2,x)+1))];
        buildTree(tree,arr,1,0,n-1);
        //System.out.println(Arrays.toString(tree));
        for(int i=0;i<n-1;i++)
        {
            int ans = query(tree,1,0,n-1,i+1,n-1);
            if(arr[i]>=ans)
                System.out.printf("%d ",arr[i]);
        }
        System.out.printf("%d ",arr[n-1]);
    }
    static void buildTree(int tree[], int[] arr, int node, int s, int e)
    {
        if(s==e)
            tree[node] = arr[s];
        else
        {
            int m = (s+e)/2;
            int l = 2*node,r =l+1;
            buildTree(tree,arr,l,s,m);
            buildTree(tree,arr,r,m+1,e);
            tree[node] = Math.max(tree[l],tree[r]);
        }
    }
    static int query(int tree[], int node, int ss, int se, int qs, int qe)
    {
        if(qs<=ss&&se<=qe)
            return tree[node];
        if(qe<ss || se<qs)
            return Integer.MIN_VALUE;
        else
        {
            int m = (ss+se)/2;
            int l = 2*node,r =l+1;
            return Math.max(query(tree,l,ss,m,qs,qe),query(tree,r,m+1,se,qs,qe));
        }
    }
}
