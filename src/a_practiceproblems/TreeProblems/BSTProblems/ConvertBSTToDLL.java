package a_practiceproblems.TreeProblems.BSTProblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;

public class ConvertBSTToDLL {
    /*Logic:
    Do inorder traversal except: instead of printing element just do the following
            If head is null....then set current node as head
            Else current node.left = prev And prev.right = current node
            prev = current node
    */

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
        BinarySearchTree binarySearchTree = BSTUtils.createBST();
        obj.convert(binarySearchTree.root);
        obj.printLL();
    }
}
