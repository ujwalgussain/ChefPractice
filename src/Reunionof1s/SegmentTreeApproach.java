package Reunionof1s;

public class SegmentTreeApproach {
    class SegmentTree
    {
        int tree[];
        int arr[];
        SegmentTree(int arr[])
        {
            int x = (int)(Math.log(arr.length)/Math.log(2));
            int len =(int)(Math.pow(2,x));
            tree = new int[len];
            this.arr=arr;
            buildTree(0,arr.length,1);
        }
        void buildTree(int start, int  end, int node)
        {
            if(start == end)
                tree[node]= arr[start];
            else
            {
                int mid = (start+end)/2;
                int l=node<<1;
                buildTree(start, mid, l);
                buildTree(mid+1,end,l+1);
                tree[node]=arr[mid]==1&&arr[mid+1]==1?tree[l]+tree[l+1]:Math.max(tree[l],tree[l+1]);
            }
        }
        void update(int idx, int node, int s, int e, int newval)
        {
            if(s<=idx && idx<=e)
            {
                if(s==e && s==idx)
                {
                    arr[idx]=newval;
                    tree[node]=newval;
                }
                else
                {
                    int mid = (s+e)/2;
                    int l=node<<1;
                    update(idx,l,s,mid,newval);
                    update(idx,l+1,mid+1,e,newval);
                    tree[node]=arr[mid]==1&&arr[mid+1]==1?tree[l]+tree[l+1]:Math.max(tree[l],tree[l+1]);
                }
            }
            else
                return;
        }
    }
}
