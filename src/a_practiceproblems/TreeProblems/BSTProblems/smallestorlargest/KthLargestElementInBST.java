package a_practiceproblems.TreeProblems.BSTProblems.smallestorlargest;

import a_practiceproblems.TreeProblems.BSTProblems.BinarySearchTree;
import a_practiceproblems.TreeProblems.BSTProblems.BSTUtils;
import a_practiceproblems.TreeProblems.tree.TreeNode;

public class KthLargestElementInBST {
    /*Logic :
    Kth smallest element will be Kth element in Reverse Inorder Traversal(RVL)
    * */
    static int c=0;
    static TreeNode get(TreeNode root, int k)
    {
        if(root == null)
            return null;
        TreeNode right = get(root.right,k);
        if(right!=null)
            return right;
        if(++c == k)
            return root;
        return get(root.left,k);
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = BSTUtils.createBST();
        System.out.println(get(binarySearchTree.root,2).val);
    }
}
