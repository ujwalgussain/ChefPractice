package LinkedListTest;

public class LinkedListWithRandomPointers {
    class Node{
        int data;
        Node next,random;
        Node(int s)
        {
            data=s;
        }
    }
    Node head;
    void insert(int n)
    {
        Node z = new Node(n);
        if(head==null)
            head=z;
        else
        {
            Node temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=z;
        }
    }
    void setRandom(int u, int v)
    {
        Node temp=head;Node src=null,dest=null;
        while(temp!=null)
        {
            if(temp.data==u)
                src=temp;
            if(temp.data==v)
                dest=temp;
            if(src !=null && dest!=null)
                break;
            temp=temp.next;
        }
        src.random=dest;
    }
    LinkedListWithRandomPointers getCloneWithRandomPtrs()
    {
        Node temp=head;
        //Cloned inside
        System.out.println("Org LL");
        display();
        while(temp!=null)
        {
            Node copy = new Node(temp.data);
            copy.next=temp.next;
            temp.next=copy;
            temp=copy.next;
        }
        System.out.println("Copied LL");
        display();
       /* LinkedListWithRandomPointers l = new LinkedListWithRandomPointers();
        l.head=head.next;*/
        temp=head;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp.next.random=temp.random==null?null:temp.random.next;
            temp=temp.next.next;
        }
        LinkedListWithRandomPointers l = new LinkedListWithRandomPointers();
        l.head=head.next;
        temp=head;
        while(temp!=null)
        {
            Node copy=temp.next;
            temp.next=copy.next;
            copy.next=copy.next.next;
            temp=temp.next.next;
        }
        l.display();
        return l;
    }
    void display()
    {
        if(head==null)
            System.out.println("Empty");
        else
        {
            Node t = head;
            while(t!=null){
                System.out.print(t.data+"["+((t.random==null)?"null":t.random.data)+"] ");
                t=t.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkedListWithRandomPointers list =new LinkedListWithRandomPointers();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.setRandom(1,3);
        list.setRandom(2,1);
        list.getCloneWithRandomPtrs();
    }
}
