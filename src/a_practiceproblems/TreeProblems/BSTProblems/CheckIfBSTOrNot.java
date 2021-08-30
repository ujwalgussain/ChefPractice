package a_practiceproblems.TreeProblems.BSTProblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;

public class CheckIfBSTOrNot {
    public static boolean isBST(TreeNode root)
    {
        if(root == null)
            return true;
        if(root.left != null &&  root.left.data>root.data)
           return false;
        if(root.right !=null && root.right.data<root.data)
            return false;
        return isBST(root.left) && isBST(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = BSTUtils.createBST();
        binarySearchTree.root.left.setData(60);
        System.out.println(isBST(binarySearchTree.root));
    }
}