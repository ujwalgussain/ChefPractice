package TreeLevelRelatedQueries.BSTProblems;

public class PrintAllAncestorsImpl {
    static boolean printAllAncestors(Node root, int key)
    {
        if(root==null)
            return false;
        if(root.data==key)
            return true;
        boolean res = printAllAncestors(root.left,key) || printAllAncestors(root.right,key);
        if(res)
            System.out.println(root.data);
        return res;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertAll(10,5,15,18,16,19,3,7,1,4,14);
        System.out.println(printAllAncestors(tree.root,19));
    }
}
