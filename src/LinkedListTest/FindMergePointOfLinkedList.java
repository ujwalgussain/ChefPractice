package LinkedListTest;

public class FindMergePointOfLinkedList {
    /*Approach 1: Traverse the list one by one and store all nodes in list. If node already present in the list then return node*/
    /*Approach 2: If lists are not equal in length then start after skipping the extra nodes in the list. Now traverse both
    *               lists and check whether next of both nodes is same. If yes then return*/
    static void findMergePoint(LinkedList list1, LinkedList list2)/*Approach 2*/
    {
        Node temp1=list1.head,temp2=list2.head;

        if(list1.length>list2.length)
        {
            int offset=list1.length-list2.length;
            while(--offset>=1)
            {
                temp1=temp1.next;
            }
        }
        else
        {
            int offset=list2.length-list1.length;
            while(--offset>=0)
            {
                temp2=temp2.next;
            }
        }
        System.out.println(temp1.data+" "+temp2.data);
        while(temp1.next!=temp2.next)
        {
            temp1=temp1.next;
            temp2= temp2.next;
        }
        System.out.println("Merge Point- "+temp1.next.data);
    }
    public static void main(String[] args) {
        /*
        * 1-2-3
        *       \
        *        6-7
        *       /
        *   4-5
        * */
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        LinkedList list1=new LinkedList();
        list1.insertNode(n1);
        list1.insertNode(n2);
        list1.insertNode(n3);
        list1.insertNode(n6);
        list1.insertNode(n7);
        LinkedList list2=new LinkedList();
        list2.insertNode(n4);
        list2.insertNode(n5);
        list2.insertNode(n6);
        list1.display();
        list2.display();
        findMergePoint(list1,list2);
    }
}
