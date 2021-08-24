package a_practiceproblems.TreeProblems.traversalproblems;

import a_practiceproblems.TreeProblems.BSTProblems.BSTUtils;
import a_practiceproblems.TreeProblems.traversalproblems.traversal.TraversalWithoutRecursion;
import a_practiceproblems.TreeProblems.tree.TreeNode;

public class PrintTraversals {

    static void printInorderTraversal() {
        TreeNode root = null;
        root = BSTUtils.createLeftSkewedTree();
        System.out.println("Left Skewed Tree " +
                TraversalWithoutRecursion.INORDER.traverse(root));
        root = BSTUtils.createRightSkewedTree();
        System.out.println("Right Skewed Tree " +
                TraversalWithoutRecursion.INORDER.traverse(root));

        root = BSTUtils.createFullBSTAndReturnRoot();
        System.out.println("Full Binary Tree " +
                TraversalWithoutRecursion.INORDER.traverse(root));
    }

    public static void main(String[] args) {
        printInorderTraversal();
    }
}
