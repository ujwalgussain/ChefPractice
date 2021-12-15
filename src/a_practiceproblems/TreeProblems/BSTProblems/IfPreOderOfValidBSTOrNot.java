package a_practiceproblems.TreeProblems.BSTProblems;

import java.util.ArrayList;
import java.util.List;

public class IfPreOderOfValidBSTOrNot {
    //Ref : https://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
    /*
    10, 5, 4, 7, 15
    start with i=0 and currEle = 10 -> range is -INF to INF
    falls in range then
        i=1 currEle = 5 range is -INF to 10
        falls in range then
            i=2 currEle = 4 range is -INF to 5
            falls in range then
                i=3 currEle = 7 not in range of -INF to 4
                return
            i=3 currEle is 7 range is 5 to 10
            falls in range
    * */
    public int solve(ArrayList<Integer> A) {
        isBST(A,A.get(0),Integer.MIN_VALUE,Integer.MAX_VALUE);
        return idx==A.size()?1:0;
    }
    int idx;
    void isBST(ArrayList<Integer> pre, int key, int min, int max){
        if(idx>=pre.size())
            return;
        int ans = 0;
        if(min <= key && key <=max){
            idx++;
            if(idx< pre.size()){
                isBST(pre,pre.get(idx),min,key);
            }
            if(idx < pre.size()){
                isBST(pre,pre.get(idx),key,max);
            }

        }
        //System.out.println(idx);
    }

    public static void main(String[] args) {
        System.out.println(new IfPreOderOfValidBSTOrNot().solve(new ArrayList<>(List.of(10,5,4))));
    }

    static int preIndex = 0;

    static void buildBST_helper(int n, int[] pre, int min, int max)
    {
        if (preIndex >= n)
            return;

        if (min <= pre[preIndex] && pre[preIndex] <= max) {

            // build node
            int rootData = pre[preIndex];
            preIndex++;

            // build left subtree
            buildBST_helper(n, pre, min, rootData);

            // build right subtree
            buildBST_helper(n, pre, rootData, max);
        }
        // else
        // return NULL;
    }

    static boolean canRepresentBST(int[] arr, int N)
    {
        // code here
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;

        buildBST_helper(N, arr, min, max);

        return preIndex == N;
    }


}
