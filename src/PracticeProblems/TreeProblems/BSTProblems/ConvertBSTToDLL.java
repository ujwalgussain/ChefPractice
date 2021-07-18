package PracticeProblems.TreeProblems.BSTProblems;

import PracticeProblems.TreeProblems.tree.TreeNode;

public class ConvertBSTToDLL {
    TreeNode prev;
    TreeNode head;
    private void convert(TreeNode root)
    {
        if(root == null)
            return;
        convert(root.left);
        if(prev == null)
            head = root;
        else
        {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convert(root.right);
    }

    private void printLL()
    {
        TreeNode temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
    }

    public static void main(String[] args) {
        ConvertBSTToDLL obj = new ConvertBSTToDLL();
        BinarySearchTree binarySearchTree = BinarySearchTreeUtils.createBST();
        obj.convert(binarySearchTree.root);
        obj.printLL();
    }
}
