package a_practiceproblems.TreeProblems.traversalproblems.traversal;

import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.Stack;

public enum TraversalWithoutRecursion
{
    INORDER{
        @Override
        public String traverse(TreeNode root) {
            StringBuilder stringBuilder = new StringBuilder();
            Stack<TreeNode> stack = new Stack<>();
            while(true)
            {
                //Go left until left most leaf is found
                while(root!=null)
                {
                    stack.push(root);
                    root=root.left;
                }
                //This means that all nodes are traversed
                if(stack.isEmpty())
                    return stringBuilder.toString();

                //If all nodes are not traversed, print and got right
                root = stack.pop();
                stringBuilder.append(root.data+" ");
                root = root.right;
            }
        }
    };
    public abstract String traverse(TreeNode root);

}
