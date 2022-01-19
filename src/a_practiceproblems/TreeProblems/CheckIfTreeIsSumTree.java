package a_practiceproblems.TreeProblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;

public class CheckIfTreeIsSumTree {
    //https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
    int isSumTree(TreeNode A){
        /*
         * Returns -1 if root doesnt form sumTree
         * Else returns sum of all children nodes of root and root*/
        if(A.left==null && A.right==null)
            return A.val;
        //check if leftSubtree forms sumTree
        int left = 0;
        if(A.left!=null)
            left = isSumTree(A.left);
        if(left==-1)
            return -1;

        //check the rightSubtree
        int right = 0;
        if(A.right!=null)
            right = isSumTree(A.right);
        if(right==-1)
            return -1;
        //check if current Node is sumTree
        if(A.val != left+right)
            return -1;
        return A.val + left+right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(22);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        System.out.println(new CheckIfTreeIsSumTree().isSumTree(root));
    }
}
