package a_practiceproblems.TreeProblems;

import java.util.ArrayList;

//Link : https://www.interviewbit.com/problems/inorder-traversal-of-cartesian-tree/
public class InorderTraversalOfCartesianTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public TreeNode buildTree(ArrayList<Integer> A) {
        return util(A, 0, A.size() - 1);
    }

    public TreeNode util(ArrayList<Integer> A, int lo, int hi) {
        if (lo > hi)
            return null;
        if (lo == hi)
            return new TreeNode(A.get(lo));
        int max = findMax(A, lo, hi);
        TreeNode root = new TreeNode(A.get(max));
        root.left = util(A, lo, max - 1);
        root.right = util(A, max + 1, hi);
        return root;
    }

    //We can use segment Tree for getting this in O(logn)
    int findMax(ArrayList<Integer> A, int lo, int hi) {
        int max = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (A.get(i) > A.get(max))
                max = i;
        }
        return max;
    }
    /*
    Ex:
    1.Find index of max Value within lo to hi
2.Now, maxValue becomes the root
3.for left subtree do step 1-4 for lo to max-1
4.for right subtree do step 1-4 for max+1 to hi

0	1	2	3	4	5	6	7
924 307 254 167 748 330 372 353

			[924 307 254 167 748 330 372 353]
				max = 924
				 /   \
			    /     \
			           \
			         [307 254 167 748 330 372 353]
			            max = 748
			            idx = 4
			            /      \
			           /        \
			          /          \
			         /            \
			      [307 254 167]    [330 372 353]
			      max = 307           max = 372
 				  idx = 1                /		\
                       \                /		 \
                        \              /		return 353
                         \          return 350
                      [254 167]
                      max=254
                      	\
                      	 \
                      return 167
    */


}
