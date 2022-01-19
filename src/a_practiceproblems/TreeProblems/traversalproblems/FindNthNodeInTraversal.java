package a_practiceproblems.TreeProblems.traversalproblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;

public class FindNthNodeInTraversal {
    class PreOrder{
        int count=0;
        TreeNode ans = null;
        public void find(TreeNode root, int k){
            if(root!=null){
                if(count<=k){
                    if(++count==k)
                        ans = root;
                    find(root.left,k);
                    find(root.right,k);
                }
            }
        }
    }

    class InOrder{
        int count=0;
        TreeNode ans = null;
        public void find(TreeNode root, int k){
            if(root!=null){
                if(count<=k){
                    find(root.left,k);
                    if(++count==k)
                        ans = root;
                    find(root.right,k);
                }
            }
        }
    }

    class PostOrder{
        int count=0;
        TreeNode ans = null;
        public void find(TreeNode root, int k){
            if(root!=null){
                if(count<=k){
                    find(root.left,k);
                    find(root.right,k);
                    if(++count==k)
                        ans = root;
                }
            }
        }
    }

}
