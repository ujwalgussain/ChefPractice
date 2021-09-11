package a_practiceproblems.TreeProblems.BSTProblems.avltrees.problems;

import a_practiceproblems.TreeProblems.BSTProblems.BinarySearchTree;
import a_practiceproblems.TreeProblems.BSTProblems.inorderproblems.FindInorderSuccessor;
import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.Arrays;

public class NextGreaterElementInRight {
    public static int[] findNextClosestGreaterElementToRight(int[] arr)
    {
        int len = arr.length;
        int[] ans = new int[len];
        //Try This with AVL Tree
        BinarySearchTree bst = new BinarySearchTree();
        ans[len-1] = -1;
        bst.insert(arr[len-1]);
        for(int i = len-2; i>=0; i--)
        {
            TreeNode insertedNode = bst.insertAndReturnNode(arr[i]);
            TreeNode inorderSuccessor = FindInorderSuccessor.findInorderSuccessor(insertedNode);
            if(inorderSuccessor==null)
                ans[i] = -1;
            else
                ans[i] = inorderSuccessor.val;
        }
        return ans;
    }
    public static void main(String[] args) {
        int a[] =
                //new int[]{10,100,93,32,35,65,80,90,94,6};
                new int[] {50,70,65,80,72,90};
        System.out.println(Arrays.toString(findNextClosestGreaterElementToRight(a)));
    }
}
