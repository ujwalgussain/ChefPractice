package a_practiceproblems.TreeProblems.traversalproblems.constructtree;

import a_practiceproblems.TreeProblems.traversalproblems.traversal.Traversal;
import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.LinkedList;

public class ConstructTreeFromLevelOrder {
    public TreeNode construct_Recursive(int[] arr, int i){
        TreeNode root = null;
        if (i < arr.length) {
            root = TreeNode.of(arr[i]);
            root.left  = construct_Recursive(arr,2*i+1);
            root.right = construct_Recursive(arr,2*i+2);
        }
        return root;
    }
    public TreeNode construct_Iterative(int[] arr){
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.add(root);
        int i=1;
        while(true){
            if(i>=arr.length)
                break;
            TreeNode curr = queue.poll();

            curr.left = new TreeNode(arr[i++]);
            queue.offerLast(curr.left);
            if(i>=arr.length)
                break;
            curr.right = new TreeNode(arr[i++]);
            queue.offerLast(curr.right);
        }
        return root;
    }
    public static void main(String[] args) {
        //TreeNode root = new ConstructTreeFromLevelOrder().construct_Recursive(new int[]{1,2,3,4,5},0);
        TreeNode root = new ConstructTreeFromLevelOrder().construct_Iterative(new int[]{1,2,3,4,5});
        Traversal.INORDER.print(root);
    }
}
