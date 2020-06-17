package LinkedListTest;

class Node{
    int data;
    Node next;
    Node(int i)
    {
        data=i;
    }
}

public class LinkedList {
    Node head;
    int length;
    void insertAll(int ...data)
    {
        for(int i:data)
        {
            insert(i);
        }
    }
    void insert(int i)
    {
        Node n = new Node(i);
        if(head==null)
            head=n;
        else
        {
            Node t = head;
            while(t.next!=null)
                t=t.next;
            t.next=n;
        }
        length++;
    }
    void insert(int i, int pos)
    {
        Node n = new Node(i);
        if(head==null)
            head=n;
        else
        {
            if(pos==1)
            {
                n.next=head;
                head=n;
            }
            else {
                Node t = head;
                int curr = 1;
                while (t.next != null && curr < pos - 1) {
                    curr++;
                    t = t.next;
                }
                n.next = t.next;
                t.next = n;
            }
        }
        length++;
    }
    void reverse()
    {
        Node t = head,prev=null,next=null;
        while(t!=null)
        {
            next = t.next;
            t.next=prev;
            prev=t;
            t=next;
        }
        head=prev;
    }
    void display()
    {
        if(head==null)
            System.out.println("Empty");
        else
        {
            Node t = head;
            while(t!=null){
                System.out.print(t.data+" ");
                t=t.next;
            }
            System.out.println();
        }
    }
    void rotateLeft(int times)
    {
        int pos=times%length;
        Node t=head;
        Node oldhead=head;
        for(int i=0;i<pos-1;i++)
        {

        }

    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.display();
        list.insert(4,10);
        list.display();
        list.reverse();
        list.display();
    }
}
