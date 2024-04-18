package a_practiceproblems.TreeProblems.diameter;

import a_practiceproblems.TreeProblems.tree.TreeNode;

public class FindDiameterOfBinaryTree {
    static int diameter = 0;
    int getDiameter(TreeNode n)
    {
        if(n == null)
            return 0;
        int left = getDiameter(n.left);
        int right = getDiameter(n.right);
        if(left + right +1 > diameter)
            diameter = left+right;
        return Math.max(left,right)+1;
    }
}
