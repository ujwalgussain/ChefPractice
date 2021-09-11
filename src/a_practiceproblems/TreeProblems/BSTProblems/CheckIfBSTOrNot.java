package a_practiceproblems.TreeProblems.BSTProblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.ArrayList;

public class CheckIfBSTOrNot {
    //This approach is wrong
    public static boolean isBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.left != null && root.left.val > root.val)
            return false;
        if (root.right != null && root.right.val < root.val)
            return false;
        return isBST(root.left) && isBST(root.right);
    }

    public int isValidBSTUsingMorrisTraversal(TreeNode A) {
        TreeNode curr = A;
        ArrayList<Integer> inorder = new ArrayList<>();
        while (curr != null) {
            if (curr.left == null) {
                if (isCurrGreaterThanLast(inorder, curr)) {
                    return 0;
                }
                inorder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;
                while (
                        pred.right != null
                                && pred.right != curr  //important
                )
                    pred = pred.right;
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    if (isCurrGreaterThanLast(inorder, curr)) {
                        return 0;
                    }
                    inorder.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return 1;
    }

    public boolean isCurrGreaterThanLast(ArrayList<Integer> inorder, TreeNode curr) {
        return inorder.size() > 0 && inorder.get(inorder.size() - 1) >= (int) curr.val;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = BSTUtils.createBST();
        binarySearchTree.root.left.setVal(60);
        System.out.println(isBST(binarySearchTree.root));
    }
}
