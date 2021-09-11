package a_practiceproblems.TreeProblems.BSTProblems.inorderproblems;

import a_practiceproblems.TreeProblems.BSTProblems.BSTUtils;
import a_practiceproblems.TreeProblems.tree.TreeNode;

public class FindInorderSuccessor {
    /*Inorder successor will either be
    *   1. If root is non-leaf node and has right subtree then,  leftmost element in right subtree
    *   2. If root is leaf node then, The first parent(bottom to up) for which root is the part of left subtree 
    *       Case 1: 
    *            A
    *           / \   -> For B ans is A ie., B itself is left child.
    *           B  C
    *       Case 2: 
    *            A
    *           / \
    *           B  C 
    *           \
    *            E    For E, ans is A ie., the first ancestor which is left child.
    * */
    public static TreeNode findInorderSuccessor(TreeNode root) {
        if (root == null)
            return null;
        if (root.right != null) {
            return findMin(root.right); // This method should be called only if right subtree is present
        }
        TreeNode parent = root.parent;
        while (parent != null && parent.right == root)
        {
            root = parent;
            parent = root.parent;
        }
        //In case of right skewed tree root will be tree's root and parent will be null.
        return parent;
    }
    public static TreeNode findMin(TreeNode root)
    {
        while(root.left != null)
        {
            root = root.left;
        }
        return root;
    }

    /*
                  10
                /    \
               /      \
              5        15
             / \     /   \
            3  8    13    19
           /\  /\   /\    /\
          2 4  6 9 11 12 18 20
       */

    public static void main(String[] args) {
        TreeNode root = BSTUtils.createFullBSTAndReturnRoot();
        System.out.println(findInorderSuccessor(root.right.right)); //15
        System.out.println(findInorderSuccessor(root));
    }
}
