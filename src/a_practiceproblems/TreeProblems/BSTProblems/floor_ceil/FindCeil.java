package a_practiceproblems.TreeProblems.BSTProblems.floor_ceil;

import a_practiceproblems.TreeProblems.BSTProblems.BSTUtils;
import a_practiceproblems.TreeProblems.tree.TreeNode;

public class FindCeil {
    /*Logic :
        Use Reverse inorder traversal R-V-L
    * */
    static TreeNode prev;
    //ceil-> next greaterThanEqualTo
    static int ceil(TreeNode root, int key) {
        if (root == null)
            return Integer.MAX_VALUE;
        if(root.data == key)
            return root.data;
        if(root.data<key)
            return ceil(root.right,key);
        return Math.min(root.data,ceil(root.left,key));
    }

    public static void main(String[] args) {
        System.out.println(ceil(BSTUtils.createBSTAndReturnRoot(), 39));
    }
}
