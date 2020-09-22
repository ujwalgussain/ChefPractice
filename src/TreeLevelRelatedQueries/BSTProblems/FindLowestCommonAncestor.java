package TreeLevelRelatedQueries.BSTProblems;

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
        if(n1<=root.data && root.data<=n2)
            ans= root;
        else
        {
            if(root.data>Math.max(n1,n2))
                ans=getLCAInBST(root.left,n1,n2);
            else
                ans = getLCAInBST(root.right,n1,n2);
        }
        return ans;
    }
    private static TreeNode getLCAUtil(TreeNode n, int n1, int n2)
    {
        if(n==null)
            return null;
        if(n.data==n1) {
            v1=true;
            return n;
        }
        if(n.data==n2)
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
