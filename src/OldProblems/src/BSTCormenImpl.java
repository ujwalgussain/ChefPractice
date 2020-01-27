package OldProblems.src;

public class BSTCormenImpl {
    class Node{
        int data;
        Node left, right, parent;
        Node(int data)
        {
            this.data = data;
        }
    }
    class BinarySearchTree
    {
        Node root;
        void insert(int data)
        {
            Node z = new Node(data);
            if(root == null)
                root = z;
            else
            {
                Node x =root, y = null;
                while(x != null)
                {
                    y = x;
                    x =(z.data<x.data)? x.left:x.right;
                }
                if(z.data < y.data)
                {
                    y.left = z;
                }
                else
                {
                    y.right = z;
                }
                z.parent = y;
                System.out.println("Sucessfully Added");
            }
        }
        void transplant(Node u , Node v)
        {
            if(root == u)
                v = root;
            else{
                if(u == u.parent.left)
                    u.parent.left = v;
                else
                    u.parent.right = v;
                if(v!=null)
                    v.parent = u.parent;
            }

        }
        Node tree_min(Node z)
        {
            Node res = z.left;
            if(res.left!=null)
            {
                res = res.left;
            }
            return res;
        }
        void deleteBSTNode(Node z)
        {
            if(z.left == null)
            {
                transplant(z,z.right);
            }
            else
            {
                if(z.right == null)
                {
                    transplant(z,z.left);
                }
                else
                {
                    Node y = tree_min(z.right);
                    if(z.parent!=y)
                    {
                        transplant(y,y.right);
                        y.right = z.right;
                        y.right.parent = y;
                    }
                    transplant(z,y);
                    y.left = z.left;
                    y.left.parent = y;

                }
            }
        }
    }
}
