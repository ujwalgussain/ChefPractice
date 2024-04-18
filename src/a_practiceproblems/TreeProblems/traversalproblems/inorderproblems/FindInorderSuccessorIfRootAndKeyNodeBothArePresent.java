package a_practiceproblems.TreeProblems.traversalproblems.inorderproblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;

public class FindInorderSuccessorIfRootAndKeyNodeBothArePresent {

    // returns the inorder successor of the Node x in BST (rooted at 'root')
    boolean foundKeyNode = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode x) {
        //add code here.
        if (root == null)
            return null;
        TreeNode left = inorderSuccessor(root.left, x);
        if (left != null)
            return left;
        if (root.val == x.val)
            foundKeyNode = true;
        else if (foundKeyNode)
            return root;
        return inorderSuccessor(root.right, x);
    }

}
