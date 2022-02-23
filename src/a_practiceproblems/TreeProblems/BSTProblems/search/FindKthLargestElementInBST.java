package a_practiceproblems.TreeProblems.BSTProblems.search;

import a_practiceproblems.TreeProblems.tree.TreeNode;

public class FindKthLargestElementInBST {
    //https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1/
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(TreeNode root, int K) {
        //Your code here
        k = K;
        TreeNode result = findKthLargestTreeNode(root);
        return result == null ? -1 : result.val;
    }

    int k;

    public TreeNode findKthLargestTreeNode(TreeNode root) {
        if (root != null) {
            TreeNode right = findKthLargestTreeNode(root.right);
            if (--k == 0)
                return root;
            if (right != null)
                return right;
            return findKthLargestTreeNode(root.left);
        }
        return null;
    }
}
