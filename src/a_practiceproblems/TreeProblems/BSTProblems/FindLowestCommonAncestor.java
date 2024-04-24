package a_practiceproblems.TreeProblems.BSTProblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;

public class FindLowestCommonAncestor {
    static boolean v1,v2; //getLCAUtil will return one of the two nodes if one if absent in the tree hence we use 2 flags
    public static TreeNode getLCA(TreeNode root, int n1, int n2)
    {
        v1=false;v2=false;
        TreeNode LCA=getLCAUtil(root,n1,n2);
        if(v1 && v2)
            return LCA;
        return null;
    }
    public static TreeNode getLCAInBST(TreeNode root, int n1, int n2)
    {
        TreeNode ans=null;
        if(root==null) {
            return null;
        }
        if(n1<=root.val && root.val <=n2)
            ans= root;
        else
        {
            if(root.val >Math.max(n1,n2))
                ans=getLCAInBST(root.left,n1,n2);
            else
                ans = getLCAInBST(root.right,n1,n2);
        }
        return ans;

        /*
        Node LCA(Node root, int n1, int n2) {
            // code here.
                Node temp = root;
                while(temp!=null) {
                    if(temp.data < n1 && temp.data <n2)
                        temp = temp.right;
                    else if (temp.data > n1 && temp.data > n2)
                        temp = temp.left;
                    else
                        return temp;
            }
            return null;
        }
        */
    }

    private static TreeNode getLCAUtil(TreeNode n, int n1, int n2)
    {
        if(n==null)
            return null;
        if(n.val ==n1) {
            v1=true;
            return n;
        }
        if(n.val ==n2)
        {
            v2=true;
            return n;
        }
        TreeNode leftLCA = getLCA(n.left,n1,n2);
        TreeNode rightLCA = getLCA(n.right,n1,n2);
        if(leftLCA!=null && rightLCA!=null)
            return n;
        return leftLCA!=null?leftLCA:rightLCA;
    }
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertAll(10,5,15,18,16,19,3,7,1,4,14);
        System.out.println(getLCAInBST(tree.root,5,19));
    }
}
