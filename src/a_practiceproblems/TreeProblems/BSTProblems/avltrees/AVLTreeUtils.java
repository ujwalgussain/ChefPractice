package a_practiceproblems.TreeProblems.BSTProblems.avltrees;

public class AVLTreeUtils {
    public static int height(AVLTreeNode x)
    {
        if(x == null)
            return 0;
        return x.height;
    }
}
