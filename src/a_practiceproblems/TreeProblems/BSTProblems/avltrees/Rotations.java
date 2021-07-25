package a_practiceproblems.TreeProblems.BSTProblems.avltrees;

import static a_practiceproblems.TreeProblems.BSTProblems.avltrees.AVLTreeUtils.height;

public enum Rotations {
    LEFT {
        @Override
        public AVLTreeNode rotate(AVLTreeNode b) {
            System.out.println("Rotate Left - " +b.data);
            AVLTreeNode a = b.right;
            b.right = a.left;
            a.left = b;
            b.height = Math.max(height(b.left), height(b.right)) + 1;
            a.height = Math.max(b.height, height(a.right)) + 1;
            return a;
        }
    },
    RIGHT {
        @Override
        public AVLTreeNode rotate(AVLTreeNode b) {
            System.out.println("Rotate Right - " +b.data);

            AVLTreeNode a = b.left;
            b.left = a.right;
            a.right = b;
            b.height = Math.max(height(b.left), height(b.right)) + 1;
            a.height = Math.max(b.height, height(a.left)) + 1;
            return a;
        }
    },
    LEFTRIGHT {
        @Override
        public AVLTreeNode rotate(AVLTreeNode b) {
            System.out.println("Rotate LeftRight - " +b.data);
            b.left = LEFT.rotate(b.left);
            return RIGHT.rotate(b);
        }
    },
    RIGHTLEFT {
        @Override
        public AVLTreeNode rotate(AVLTreeNode b) {
            System.out.println("Rotate RightLeft - " +b.data);
            b.right = RIGHT.rotate(b.right);
            return LEFT.rotate(b);
        }
    };

    public abstract AVLTreeNode rotate(AVLTreeNode avlTreeNode);
}
