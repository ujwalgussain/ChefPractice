package a_practiceproblems.TreeProblems.BSTProblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;
import sun.reflect.generics.tree.Tree;

public class BSTUtils {
      /*
            10
            / \
            5  30
               / \
               20 40

       */
    public static BinarySearchTree createBST()
    {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertAll(10,5,30,40,20);
        return binarySearchTree;
    }
    public static TreeNode createBSTAndReturnRoot()
    {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertAll(10,5,30,40,20);
        return binarySearchTree.root;
    }

    public static TreeNode createFullBSTAndReturnRoot()
    {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertAll(10,5,15,3,8,13,19,2,4,6,9,11,14,18,20);
        return binarySearchTree.root;

        /*
                   10
                 /    \
                /      \
               5        15
              / \     /   \
             3  8    13    19
            /\  /\   /\    /\
           2 4  6 9 11 14 18 20
        */
    }

    public static TreeNode createLeftSkewedTree()
    {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertAll(10,9,8,7,6);
        return binarySearchTree.root;
    }

    public static TreeNode createRightSkewedTree()
    {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertAll(1,2,3,4,5,6);
        return binarySearchTree.root;
    }
    public static TreeNode searchNode(TreeNode root, int key)
    {
        while(root != null)
        {
            if(root.data == key)
                return root;
            if(key < root.data)
                root = root.left;
            else
                root = root.right;
        }
        return null;
    }
}
