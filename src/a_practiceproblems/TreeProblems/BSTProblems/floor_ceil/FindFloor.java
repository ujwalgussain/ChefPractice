package a_practiceproblems.TreeProblems.BSTProblems.floor_ceil;

import a_practiceproblems.TreeProblems.BSTProblems.BSTUtils;
import a_practiceproblems.TreeProblems.tree.TreeNode;

public class FindFloor {
    /*Logic :
        Use inorder traversal L-V-R,
            if root == key return root
            if root>key return prev
            prev = root
    * */
    static TreeNode prev = null;
    static TreeNode getFloorNode(TreeNode root, int key) {
        if (root == null)
            return root;
        //Go Left
        TreeNode left = getFloorNode(root.left,key);
        //Visit
        if(left != null)
            return left;
        if(root.val == key)
            return root;
        if(root.val > key)
            return prev;
        prev = root;

        //Go Right
        return getFloorNode(root.right,key);
    }

    public static void main(String[] args) {
        int ans = getFloorNode(BSTUtils.createBSTAndReturnRoot(),12).getVal();
        System.out.println(ans);
    }
}
