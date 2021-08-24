package a_practiceproblems.TreeProblems.BSTProblems;

import a_practiceproblems.TreeProblems.traversalproblems.traversal.Traversal;
import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.Arrays;

public class CreateBSTFromUnsortedArray {
    public static TreeNode get(int[] arr, int s, int e){
        //VVImp : arr must be a sorted array
        if(s>e)
        {
            return null;
        }
        if(s==e)
        {
            return new TreeNode(arr[s]);
        }
        int mid = (s+e)/2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = get(arr,s,mid-1);
        node.right = get(arr,mid+1,e);
        return node;
    }
    public static TreeNode get(int[] arr) {
        Arrays.sort(arr);
        return get(arr,0,arr.length-1);
    }
    public static void main(String[] args) {
        TreeNode root = get(new int[] {1,2,3,4,5});
        Traversal.INORDER.print(root);
    }
}
