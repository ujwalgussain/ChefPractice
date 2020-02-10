public class BST_Impl {
    class Tree{
        class Node{
            int data;Node left,right;
            Node(int d)
            {
                data=d;
            }
        }
        Node root;
        void insert(int d)
        {
            Node n = new Node(d);
            if(root==null)
            {
                root=n;
            }
            else
            {
                Node p=root,q=null;
                while(p!=null)
                {
                    q=p;
                    p=(d<p.data)?p.left:p.right;
                }
                if(d<q.data)
                    q.left=n;
                else
                    q.right=n;
            }
        }
    }
}
