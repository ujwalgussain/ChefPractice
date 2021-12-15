package a_practiceproblems.TreeProblems;

import java.util.HashSet;
import java.util.LinkedList;

public class TwoSumBinaryTree {
    //https://www.interviewbit.com/problems/2sum-binary-tree/
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
    public int t2Sum(TreeNode A, int B) {
        LinkedList<TreeNode> queue = new LinkedList();
        HashSet<Integer> set = new HashSet<>();
        queue.add(A);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(set.contains(B-curr.val))
                return 1;
            set.add(curr.val);
            if(curr.left!=null)
                queue.add(curr.left);
            if (curr.right!=null)
                queue.add(curr.right);
        }
        return 0;
    }
}
