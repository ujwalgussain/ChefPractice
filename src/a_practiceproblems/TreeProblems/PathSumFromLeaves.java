package a_practiceproblems.TreeProblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;

public class PathSumFromLeaves {
    //https://practice.geeksforgeeks.org/problems/maximum-path-sum/1/#

    int maxVal = Integer.MIN_VALUE;
    int maxPathSum(TreeNode root)
    {
        // code here
        //If Tree is left skewed or right skewed the null art should be considered as 0
        if(root.left==null)
            root.left = new TreeNode(0);
        if(root.right==null)
            root.right = new TreeNode(0);

        maxPathSumUtil(root);
        return maxVal;

    }

    int maxPathSumUtil(TreeNode root)
    {
        // code here 
        if(root==null)
            return 0;
        //avoid going to null nodes
        if(root.left==null && root.right==null)
            return root.val;
        int left = maxPathSumUtil(root.left);
        int right = maxPathSumUtil(root.right);
        if(root.left!=null && root.right!=null){
            maxVal = Math.max(maxVal , root.val + left + right);
            return Math.max(left,right) + root.val;
        }
        return (root.left==null?right:left)+root.val;
    }

}
