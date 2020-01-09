package MergeSortTree;

import java.util.*;

public class MergeSortTreeImpl {
    static void buildTree(int arr[],int idx, int start, int end, List<Map.Entry<Integer,Integer>> v, List<Integer> tree[])
    {
        if(start==end)
        {
            List<Integer> l = new ArrayList<>();
            l.add(v.get(start).getValue());
            tree[idx]= l;
        }
        else
        {
            int mid =(start+end)/2;
            int left=2*idx,right=left+1;
            buildTree(arr,left,start,mid,v,tree);
            buildTree(arr,right,mid+1,end,v,tree);
            List<Integer> l = new ArrayList<>();
            l.addAll(tree[left]);
            l.addAll(tree[right]);
            Collections.sort(l);
            tree[idx] = l;
        }
    }
    static int getUpperBound(List<Integer> treeNode, int k)
    {
        int i = 0;
        for(int a: treeNode)
        {
            if(a>k)
                return i;
            i++;
        }
        return i;
    }
    int queryRec(int segmentStart, int segmentEnd,
                 int queryStart, int queryEnd, int node,
                 int K, List<Integer> tree[])
    {
    /*
        segmentStart => start of a Segment,
        segmentEnd   => ending of a Segment,
        queryStart   => start of a query range,
        queryEnd     => ending of a query range,
        treeIndex    => index in the Segment
                        Tree/Merge Sort Tree,
        K  => kth smallest number to find  */

        if (segmentStart == segmentEnd)
            return tree[node].get(0);

        int mid = (segmentStart + segmentEnd) / 2;

        // finds the last index in the segment
        // which is <= queryEnd
        int last_in_query_range =
                            (upper_bound(tree[2 * treeIndex].begin(),
                        tree[2 * treeIndex].end(),
                        queryEnd)
                        - tree[2 * treeIndex].begin());

        // finds the first index in the segment
        // which is >= queryStart
        int first_in_query_range =
                (lower_bound(tree[2 * treeIndex].begin(),
                        tree[2 * treeIndex].end(),
                        queryStart)
                        - tree[2 * treeIndex].begin());

        int M = last_in_query_range - first_in_query_range;

        if (M >= K) {

            // Kth smallest is in left subtree,
            // so recursively call left subtree for Kth
            // smallest number
            return queryRec(segmentStart, mid, queryStart,
                    queryEnd, 2 * treeIndex, K, tree);
        }

        else {

            // Kth smallest is in right subtree,
            // so recursively call right subtree for the
            // (K-M)th smallest number
            return queryRec(mid + 1, segmentEnd, queryStart,
                    queryEnd, 2 * treeIndex + 1, K - M, tree);
        }
    }
    static public void main(String args[])
    {
        int [] arr = {3,2,5,1,8,9};
        List<Map.Entry<Integer,Integer>> v = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            AbstractMap.SimpleEntry<Integer,Integer> entry = new AbstractMap.SimpleEntry<>(arr[i],i);
            v.add(entry);
        }
        Collections.sort(v, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        System.out.println(v);
        List<Integer> tree[] = new List[50];
        buildTree(arr,1,0,arr.length-1,v,tree);
        System.out.println("sTree:");
        for(List l : tree)
        {
            if(l!=null) System.out.println(l);
        }
        System.out.println("Final Ans = " + queryRec(1,0,arr.length-1,
                1,arr.length-1,2,v,tree,""));

    }
}
