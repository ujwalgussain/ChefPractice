package a_practiceproblems.TreeProblems;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ReplaceNodeWithSumOfInorderPredecessorAndSuccessor {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    void replaceNodeByFindingInOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        ArrayList<Integer> inorderList = new ArrayList<>();
        inorderList.add(0);
        generateInorderTraversal(inorderList, root); //Just store the inorder Traversal in ArrayList
        inorderList.add(0);
        replaceNodeUtil(root, inorderList);
    }

    void generateInorderTraversal(ArrayList<Integer> list, TreeNode root) {
        if (root == null)
            return;
        generateInorderTraversal(list, root.left);
        list.add(root.val);
        generateInorderTraversal(list, root.right);
    }

    int idx = 1;

    void replaceNodeUtil(TreeNode root, ArrayList<Integer> inorder) {
        if (root == null)
            return;
        replaceNodeUtil(root.left, inorder);
        root.val = inorder.get(idx - 1) + inorder.get(idx + 1);
        idx++;
        replaceNodeUtil(root.right, inorder);
    }

    //=========================================Better Approach============================================================================//
    int replaceNode(TreeNode A){
        if(A==null)
            return 0;
        //If Leaf Node then value will not change
        if(A.left==null && A.right==null)
            return A.val;
        int left = replaceNode(A.left);
        int right = replaceNode(A.right);
        int oldVal = A.val;
        //update the value
        A.val=left+right;
        return oldVal;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

       // new ReplaceNodeWithSumOfInorderPredecessorAndSuccessor().replaceNode(root);

        new ReplaceNodeWithSumOfInorderPredecessorAndSuccessor().replaceNode(root);
        return;
    }
}
