package a_practiceproblems.TreeProblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;

public class DivideBTreeIntoTwoHalves {
    boolean result;
    public int check(TreeNode root, int totalNodes) {
        if(root == null)
            return 0;
        int subtreeCnt = 1 + check(root.left,totalNodes) + check(root.right,totalNodes);
        if(totalNodes-subtreeCnt == subtreeCnt) {
            result = true;
        }
        return subtreeCnt;
    }

    public static boolean checkIfBTreeCanBeDivided(TreeNode root) {
        DivideBTreeIntoTwoHalves d = new DivideBTreeIntoTwoHalves();
        d.check(root,CountNodesInTree.count(root));
        return d.result;
    }

    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            System.out.println("Index = "+ i);
            int index = i;
            while(index <= n)
            {
                // Add 'val' to current node of BIT Tree

                // Update index to that of parent
                // in update View
                System.out.println("\t" + index);
                index += index & (-index);
            }
        }

    }
}
