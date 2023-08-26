package a_practiceproblems.TreeProblems.traversalproblems.inorderproblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;

public class FindPreOrderSuccessor {

    /*
                   10
                 /    \
                /      \
               5       15
              / \     /   \
             3  8    13    19
    PreOrder is like 10,5,3,8,15,13,19

    There are 2 cases
        if non leaf node
            return left OR right
        if leaf Node
            find 1st parent such that --> parent.left == root && parent.right != null

    * */

    static TreeNode findPreorderSuccessor(TreeNode root) {
        if (root == null)
            return null;

        // If the node has a left child, return it
        if (root.left != null) {
            return root.left;
        }

        // If the node has a right child, return it
        if (root.right != null) {
            return root.right;
        }

        TreeNode parent = root.parent;
        while (parent != null) {
            if (parent.left == root && parent.right != null) {
                return parent.right;
            }
            root = parent;
            parent = root.parent;
        }

        return null;
    }
}