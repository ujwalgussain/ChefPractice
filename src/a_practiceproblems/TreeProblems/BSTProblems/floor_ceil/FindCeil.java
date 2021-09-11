package a_practiceproblems.TreeProblems.BSTProblems.floor_ceil;

import a_practiceproblems.TreeProblems.BSTProblems.BSTUtils;
import a_practiceproblems.TreeProblems.tree.TreeNode;

public class FindCeil {
    /*Logic :
        Use Reverse inorder traversal R-V-L
    * */

    //ceil-> next greaterThanEqualTo
    static int ceil(TreeNode root, int key) {
        if (root == null)
            return Integer.MAX_VALUE;
        if(root.val == key)
            return root.val;
        if(root.val <key)
            return ceil(root.right,key);
        return Math.min(root.val,ceil(root.left,key));
    }
    static TreeNode next = null;
    static TreeNode ceil2(TreeNode root, int key) {
        if (root == null)
            return null;
        TreeNode right = ceil2(root.right,key);
        if(right!=null)
            return right;
        if(root.val ==key)
            return root;
        if(root.val <key)
            return next;
        next=root;
        return ceil2(root.left,key);
    }

    public static void main(String[] args) {

        TreeNode root = BSTUtils.createBSTAndReturnRoot();
        System.out.println(ceil(root, 39));
        System.out.println(ceil2(root, 39));
    }
}
