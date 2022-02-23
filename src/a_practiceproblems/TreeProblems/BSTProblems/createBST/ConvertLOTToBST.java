package a_practiceproblems.TreeProblems.BSTProblems.createBST;

import a_practiceproblems.TreeProblems.tree.TreeNode;

public class ConvertLOTToBST {
    /*
    We can simply insert the data
     */
    public TreeNode constructBST(int[] arr) {
        //Write your code here 
        TreeNode root = null;
        ;
        for (int i : arr)
            root = insert(root, i);
        return root;
    }

    public TreeNode insert(TreeNode root, int x) {
        if (root == null)
            return new TreeNode(x);
        TreeNode y = null, temp = root;
        while (temp != null) {
            y = temp;
            if (temp.val < x)
                temp = temp.right;
            else
                temp = temp.left;
        }
        if (y.val < x)
            y.right = new TreeNode(x);
        else
            y.left = new TreeNode(x);
        return root;
    }
}
