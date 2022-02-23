package a_practiceproblems.TreeProblems.BSTProblems.search;

import a_practiceproblems.TreeProblems.tree.TreeNode;

public class FindKthSmallestElementInBST {
    public int KthSmallestElement(TreeNode root, int K) {
        // Write your code here
        k=K;
        TreeNode result = findKthSmallestNode(root);
        return result==null?-1:result.val;

    }
    int k;
    public TreeNode findKthSmallestNode(TreeNode root){
        if(root!=null){
            TreeNode left = findKthSmallestNode(root.left);
            if(--k==0)
                return root;
            if(left!=null)
                return left;
            return findKthSmallestNode(root.right);
        }
        return null;
    }
}
