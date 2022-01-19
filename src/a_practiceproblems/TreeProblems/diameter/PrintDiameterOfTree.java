package a_practiceproblems.TreeProblems.diameter;

import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.ArrayList;

public class PrintDiameterOfTree {

    ArrayList<Integer> printDiam(TreeNode A){
        if(A==null)
            return new ArrayList<>();
        printDiamUtil(A);
        ArrayList<Integer> longestPath = new ArrayList<>();
        longestPath.addAll(leftPath);
        longestPath.addAll(rightPath);
        return longestPath;

    }
    //Store the final answer
    ArrayList<Integer> leftPath = new ArrayList<>();
    ArrayList<Integer> rightPath = new ArrayList<>();

    //similar to Find Diameter of Tree

    ArrayList<Integer> printDiamUtil(TreeNode A) {
        if (A == null)
            return new ArrayList<>();
        ArrayList<Integer> left = printDiamUtil(A.left);
        ArrayList<Integer> right = printDiamUtil(A.right);

        if (leftPath.size() + rightPath.size()
                < 1 + left.size() + right.size()) {
            leftPath = new ArrayList<>(left);
            leftPath.add(A.val);
            rightPath = new ArrayList<>(right);
        }
        if (left.size() >= right.size()) {
            left.add(A.val);
            return left;
        } else {
            right.add(A.val);
            return right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(22);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(12);

        ArrayList<Integer> diameter = new PrintDiameterOfTree().printDiam(root);
        System.out.println(diameter);
    }
}
