package a_practiceproblems.TreeProblems.BSTProblems.smallestorlargest;

import a_practiceproblems.TreeProblems.BSTProblems.BinarySearchTree;
import a_practiceproblems.TreeProblems.BSTProblems.BSTUtils;
import a_practiceproblems.TreeProblems.tree.TreeNode;

public class KthSmallestElementInBST {
    /*Logic :
    Kth smallest element will be Kth element in Inorder Traversal(LVR)
    * */
    static int c = 0;
    static TreeNode get(TreeNode root, int k)
    {
        if(root == null)
            return null;
        TreeNode left = get(root.left,k);
        if(left != null)
            return left;
        if(++c == k)
            return root;
        return get(root.right,k);
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = BSTUtils.createBST();
        System.out.println(get(binarySearchTree.root,2).data);
    }
}
