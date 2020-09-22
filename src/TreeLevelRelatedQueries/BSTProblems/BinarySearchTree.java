package TreeLevelRelatedQueries.BSTProblems;

import java.util.LinkedList;

public class BinarySearchTree {
    TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void insertAll(int ...args)
    {
        for(int i:args)
            insert(i);
    }
    void insert(int d)
    {
        TreeNode n = new TreeNode(d);
        if(root==null)
        {
            root = n;
        }
        else
        {
            TreeNode x = root,y=null;
            while(x!=null)
            {
                y=x;
                if(x.data<d)
                    x=x.right;
                else
                    x=x.left;
            }
            if(y.data<d)
                y.right=n;
            else
                y.left=n;
        }
    }
    void delete(int key)
    {
        delete_Rec(root,key);
    }
    private TreeNode delete_Rec(TreeNode root, int key)
    {
        if(root==null)
            return null;
        if(root.data<key)
        {
            root.right=delete_Rec(root.right,key);
        }
        else {
            if (root.data > key) {
                root.left = delete_Rec(root.left, key);
            }
            else
            {
                if(root.right==null) {
                    return root.left;
                }
                if(root.left==null){
                    return root.right;
                }
                int min=getMinValue(root.right);
                root.data=min;
                root.right=delete_Rec(root.right,min);
            }
        }
        return root;
    }
    int getMinValue(TreeNode root)
    {
        int min=root.data;
        while(root.left!=null)
        {
            min=root.left.data;
            root=root.left;
        }
        return min;
    }
    void display(Traversal travesal)
    {
        switch (travesal)
        {
            case LEVELORDER:
            {
                LinkedList<TreeNode> list=new LinkedList<>();
                list.add(root);
                System.out.print("LOT - ");
                while(!list.isEmpty())
                {
                    TreeNode t = list.pollFirst();
                    System.out.print(t.data+" ");
                    if(t.left!=null)
                        list.add(t.left);
                    if(t.right!=null)
                        list.add(t.right);
                }
                System.out.println();
            }
        }
    }
}
