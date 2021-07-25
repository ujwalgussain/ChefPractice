package a_practiceproblems.TreeProblems.BSTProblems;

import a_practiceproblems.TreeProblems.Traversal;
import a_practiceproblems.TreeProblems.tree.TreeNode;
import sun.reflect.generics.tree.Tree;

public class TrimBST {
    public static TreeNode trimNodesOutsideRange(TreeNode root , int min, int max)
    {
        if(root == null)
            return null;
        root.left = trimNodesOutsideRange(root.left,min,max);
        root.right = trimNodesOutsideRange(root.right,min,max);
        if(root.data < min)
            return root.right;
        if(root.data>max)
            return root.left;
        return root;

    }
    public static void main(String[] args) {
        Traversal.INORDER.print(trimNodesOutsideRange(BSTUtils.createBSTAndReturnRoot(),10,22));
    }
}
