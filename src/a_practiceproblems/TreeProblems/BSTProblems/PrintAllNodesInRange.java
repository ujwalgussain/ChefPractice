package a_practiceproblems.TreeProblems.BSTProblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;

public class PrintAllNodesInRange {
    static void print(TreeNode root, int min, int max)
    {
        if(root!=null)
        {
            if(min <= root.data)
                print(root.left,min,max);
            if(min <= root.data && root.data <=max)
                System.out.println(root.data);
            if(root.data <= max)
                print(root.right,min,max);
        }
    }

     public static void main(String[] args) {
        TreeNode root = BSTUtils.createBSTAndReturnRoot();
        print(root,3,25);
    }
}
