public class BinarySearchTreeImpl {

}

class Node{
    public int data;
    public Node left = null, right = null;

    Node(int data){
        this.data = data;

    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

class BST{
    Node root = null;
    void insert(int data){
        Node newNode = new Node(data);
        if(root==null)
        {
            root = newNode;
        }
        else{
            Node temp = root;
            while(temp!=null)
            {
                if(temp.getData()<newNode.getData())
                {
                    temp = temp.getLeft();
                }
                else{
                    temp = temp.getRight();
                }
            }
            temp = newNode;
        }
    }
    void inOrderTraversal(Node root)
    {
        System.out.println(root.getData());
    }
    public int inorderSuccessor(Node root, Node x) {
        // add code here.
        Node successor = null;
        while(root!=null) {
            if(x.data>=root.data) {
                root = root.right;
            } else {
                successor=root;
                root=root.left;
            }
        }
        return successor != null ? successor.data : -1;
    }
}