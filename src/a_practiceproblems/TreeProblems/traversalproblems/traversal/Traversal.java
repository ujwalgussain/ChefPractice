package a_practiceproblems.TreeProblems.traversalproblems.traversal;

import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.LinkedList;

public enum Traversal {
    INORDER {
        @Override
        public void print(TreeNode root) {
            if(root != null)
            {
                print(root.left);
                System.out.println(root);
                print(root.right);
            }
        }
    },
    PREORDER {
        @Override
        public void print(TreeNode root) {
            if(root != null)
            {
                System.out.println(root);
                print(root.left);
                print(root.right);
            }
        }
    },
    POSTORDER {
        @Override
        public void print(TreeNode root) {
            if(root != null)
            {
                print(root.left);
                print(root.right);
                System.out.println(root);
            }
        }
    },
    LEVELORDER {
        @Override
        public void print(TreeNode root) {
            if(root == null)
                System.out.println("Tree is empty");
            LinkedList<TreeNode> list = new LinkedList();
            list.add(root);
            while(!list.isEmpty())
            {
                TreeNode node = list.pollFirst();
                if(node.left!=null)
                    list.add(node.left);
                if(node.right!=null)
                    list.add(node.right);
            }
        }
    };

    public abstract void print(TreeNode root);
}