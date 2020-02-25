public class SegmentTree{
    int tree[];int N;
    void buildTree(int arr[])
    {
        int x = (int)Math.ceil(Math.log(arr.length)/Math.log(2));
        int len =2*(int)Math.pow(2,x);
        tree = new int[len];
        N=arr.length;
        buildTree(arr,1,0,N-1);

    }
    void buildTree(int[] arr, int idx,int s, int e)
    {
        if(s==e)
            tree[idx]=arr[s];
        else{
            int mid= (s+e)/2,left=idx<<1,right=left+1;
            buildTree(arr,left,s,mid);
            buildTree(arr,right,mid+1,e);
            tree[idx]=Math.max(tree[left],tree[right]);
        }
    }
    int query(int qs, int qe)
    {
        return query(1,0,N-1,qs,qe);
    }
    int query(int idx, int ss, int se, int qs, int qe)
    {
        if(qs<=ss && qe>=se)
            return tree[idx];
        if(qe<ss || se<qs)
            return 0;
        int mid= (ss+se)/2,left=idx<<1,right=left+1;
        return Math.max(query(left,ss,mid,qs,qe),query(right,mid+1,se,qs,qe));
    }
}