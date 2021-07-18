package PracticeProblems.TreeProblems.segmenttree;

import java.util.Arrays;

class MinSegmentTree
{
    int tree[],arr[];
    int getLen(int len)
    {
        int a=2;
        while(a<len)
            a<<=1;

        return (2*a-1)+1;
    }
    MinSegmentTree(int arr[])
    {
        tree=new int[getLen(arr.length)];
        this.arr=arr;
        initialize_ST();
        System.out.println("len " + tree.length);
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
            System.out.printf("tree[%s] = %s\n",node,arr[ss]);
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
        System.out.printf("ss-%s, se-%s, node-%s\n",ss,se,node);
        if(qs<=ss&&se<=qe) {
            System.out.printf("return tree[%s] = %s \n", node,tree[node]);
            return tree[node];
        }
        if(se<qs||ss>qe){
            System.out.println("Return "+ Integer.MAX_VALUE);
            return Integer.MAX_VALUE;
        }
        int mid = (ss+se)/2;
        System.out.println("Mid " + mid);
       // System.out.printf("ss-%s, se-%s, node-%s, mid-%s\n",ss,se,node,mid);
        int a1 = getMinInRange(ss,mid,qs,qe,2*node);
        int a2 = getMinInRange(mid+1,se,qs,qe,2*node+1);
        System.out.printf("Min(%s,%s)\n",a1,a2);
        return Math.min(a1,a2);
    }
    void displayTree()
    {
        System.out.println(Arrays.toString(tree));
    }

    static public void main(String args[])
    {
        MinSegmentTree ms = new MinSegmentTree(new int[]{375, 750, 723, 662, 647, 656, 619});
        ms.displayTree();
        System.out.println("1-6 -> "+ms.getMinInRange(1,6));
    }
}