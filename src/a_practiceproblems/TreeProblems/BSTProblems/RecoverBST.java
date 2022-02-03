package a_practiceproblems.TreeProblems.BSTProblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.*;

public class RecoverBST {
    /*  https://leetcode.com/problems/recover-binary-search-tree/
      https://www.interviewbit.com/problems/recover-binary-search-tree/
  */
    /*
Perform Inorder Traversal
   There are 2 cases:
   If the nodes are parent-child: first and middle will  have the answer
   If nodes are not parent-child: first and last will have the answer
   Hence check if last!=null
       then ans is first and last
       else ans is first and middle
   */
    public ArrayList<Integer> recoverTree(TreeNode A) {
        inorder(A);
        ArrayList<Integer> al = new ArrayList<>();
        al.add(first.val);
        if (last != null)
            al.add(last.val);
        else
            al.add(middle.val);
        return al;
    }

    TreeNode prev, first, middle, last;

    private void inorder(TreeNode A) {
        if (A == null)
            return;
        inorder(A.left);
        //If inorder traversal is not in ascending order
        if (prev != null && A.val < prev.val) {
            if (first == null) {
                first = prev;
                middle = A;
            } else {
                last = A;
            }
        }
        prev = A;
        inorder(A.right);
    }


}
