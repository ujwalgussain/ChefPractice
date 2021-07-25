package a_practiceproblems.TreeProblems.BSTProblems.inorderproblems;

import a_practiceproblems.TreeProblems.BSTProblems.BSTUtils;
import a_practiceproblems.TreeProblems.tree.TreeNode;

public class InorderPredecessor {
    /* rightmost element in left subtree
       OR
     Parent for which the node is part of right subtree
   */
    static TreeNode findInorderPredecessor(TreeNode root) {
        if(root == null)
            return null;
        if(root.left != null)
        {
            root =root.left;
            while(root.right != null)
                root = root.right;
            return root;
        }
        TreeNode parent = root.parent;
        while(parent != null && parent.left == root)
        {
            root = parent;
            parent = root.parent;
        }
        return parent;
    }

     /*
                   10
                 /    \
                /      \
               5       15
              / \     /   \
             3  8    13    19
            /\  /\   /\    /\
           2 4  6 9 11 14 18 20
    */

    public static void main(String[] args) {
        TreeNode root = BSTUtils.createFullBST();
        TreeNode n_15 = BSTUtils.searchNode(root, 15);
        System.out.println("Predecessor for 15 is " + findInorderPredecessor(n_15)); //15

        TreeNode n_4 = BSTUtils.searchNode(root, 4);
        System.out.println("Predecessor for 4 is " + findInorderPredecessor(n_4)); //4

    }
}
