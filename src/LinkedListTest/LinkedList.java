package LinkedListTest;



public class LinkedList {
    public LLNode head;
    public int length;

    public LLNode getHead() {
        return head;
    }

    public void setHead(LLNode head) {
        this.head = head;
    }

    @Override
    public String toString() {
        StringBuilder listData = new StringBuilder();
        if(head!=null)
        {
            LLNode t = head;
            while(t.next!=null){
                listData.append(t.data).append("->");
                t=t.next;
            }
            listData.append(t.data);
        }
        return String.format("{%s}",listData.toString());
    }

    public void insertAll(int ...data)
    {
        for(int i:data)
        {
            insert(i);
        }
    }
    public void insertNode(LLNode n)
    {
        if(head==null)
            head=n;
        else
        {
            LLNode t = head;
            while(t.next!=null)
                t=t.next;
            t.next=n;
        }
        length++;
    }
    public void insert(int i)
    {
        LLNode n = new LLNode(i);
        insertNode(n);
    }
    public void insert(int i, int pos)
    {
        LLNode n = new LLNode(i);
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
                LLNode t = head;
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
    public void reverse()
    {
        LLNode t = head,prev=null,next=null;
        while(t!=null)
        {
            next = t.next;
            t.next=prev;
            prev=t;
            t=next;
        }
        head=prev;
    }
    public void display()
    {
        if(head==null)
            System.out.println("Empty");
        else
        {
            LLNode t = head;
            while(t!=null){
                System.out.print(t.data+" ");
                t=t.next;
            }
            System.out.println();
        }
    }
    public void rotateLeft(int times)
     {
        int pos=times%length;
        LLNode t=head;
        LLNode oldhead=head;
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
