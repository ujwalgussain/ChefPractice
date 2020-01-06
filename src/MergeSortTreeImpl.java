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
    static int queryRec(int node, int start, int end, int ss, int se,
                 int k, List<Map.Entry<Integer,Integer>> v, List<Integer> tree[])
    {
        /* If out of range return 0 */
        if (ss > end || start > se)
            return 0;

        /* if inside the range return count */
        if (ss <= start && se >= end)
        {
        /* binary search over the sorted vector
           to return count >= X */
            /*return upper_bound(tree[node].begin(),
                    tree[node].end(), k) -
                    tree[node].begin();*/
            return (Math.abs(Collections.binarySearch(tree[node],k))-1)-tree[node].get(0);
        }

        int mid = (start+end)/2;

        /*searching in left subtree*/
        int p1 = queryRec(2*node, start, mid, ss, se, k, v, tree);

        /*searching in right subtree*/
        int p2 = queryRec(2*node+1, mid+1, end, ss, se, k, v, tree);

        /*adding both the result*/
        return p1 + p2;
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
        System.out.println(queryRec(1,0,arr.length-1,0,arr.length-1,4,v,tree));

    }
}
