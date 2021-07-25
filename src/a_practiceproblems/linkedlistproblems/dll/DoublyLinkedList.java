package a_practiceproblems.linkedlistproblems.dll;

public class DoublyLinkedList {
    public DLLNode head,tail;
    public void insert(int data)
    {
        DLLNode node = new DLLNode(data);
        if(head == null){
            head = node;
            tail = node;
        }
        else
        {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }
    public static DoublyLinkedList of(int ele1, int... eles)
    {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insert(ele1);
        for(int ele : eles)
            dll.insert(ele);
        return dll;
    }
    public static void display(DLLNode head)
    {
        while(head!=null)
        {
            System.out.print(head + " ");
            head = head.next;
        }
        System.out.println();
    }


}
