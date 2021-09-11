package a_practiceproblems.TreeProblems.BSTProblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;

public class PrintAllNodesInRange {
    static void print(TreeNode root, int min, int max)
    {
        if(root!=null)
        {
            if(min <= root.val)
                print(root.left,min,max);
            if(min <= root.val && root.val <=max)
                System.out.println(root.val);
            if(root.val <= max)
                print(root.right,min,max);
        }
    }

     public static void main(String[] args) {
        TreeNode root = BSTUtils.createBSTAndReturnRoot();
        print(root,3,25);
    }
}
