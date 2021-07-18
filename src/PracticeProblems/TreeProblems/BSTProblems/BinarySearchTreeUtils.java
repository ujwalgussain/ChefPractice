package PracticeProblems.TreeProblems.BSTProblems;

import PracticeProblems.TreeProblems.tree.TreeNode;

public class BinarySearchTreeUtils {
    public static BinarySearchTree createBST()
    {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertAll(10,5,30,40,20);
        return binarySearchTree;
    }
}
