package a_practiceproblems.TreeProblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class BoundaryTraversal {
    public void m1(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<TreeNode> leaf = new ArrayList<>();
        List<TreeNode> leftb = new ArrayList<>();
        List<TreeNode> rightb = new ArrayList<>();
        TreeNode left = null, right = null;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr == null) {
                //New level
                leftb.add(left);
                if (right != null)
                    rightb.add(right);
                left = null;
                right = null;
            } else {
                if (curr.left == null && curr.right == null) {
                    leaf.add(curr);
                } else {
                    if (left == null) {
                        left = curr;
                    } else {
                        right = curr;
                    }
                }
            }
        }
        System.out.println(leftb +" " +leaf +  " " + rightb);
    }
}
